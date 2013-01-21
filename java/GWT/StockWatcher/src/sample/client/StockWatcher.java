package sample.client;

import java.util.ArrayList;
import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class StockWatcher implements EntryPoint {

	private static final int REFRESH_INTERVAL = 5000;

	private StockPriceServiceAsync stockPriceSvc = GWT.create(StockPriceService.class);
	private StockWatcherConstants constants = GWT.create(StockWatcherConstants.class);
	private StockWatcherMessages messages = GWT.create(StockWatcherMessages.class);
	private Button addStockButton = new Button(constants.add());	
	private VerticalPanel mainPanel = new VerticalPanel();
	private FlexTable stocksFlexTable = new FlexTable();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private TextBox newSymbolTextBox = new TextBox();
	private Label lastUpdatedLabel = new Label();
	private Label errorMsgLabel = new Label();
	private ArrayList<String> stocks = new ArrayList<String>();
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Window.setTitle(constants.stockWatcher());
		RootPanel.get("appTitle").add(new Label(constants.stockWatcher()));
		
		//Create table for stock data.
		stocksFlexTable.setText(0, 0, constants.symbol());
		stocksFlexTable.setText(0, 1, constants.price());
		stocksFlexTable.setText(0, 2, constants.change());
		stocksFlexTable.setText(0, 3, constants.remove());
		
		stocksFlexTable.getRowFormatter().addStyleName(0, "watchListHeader");
		stocksFlexTable.addStyleName("watchList");
		stocksFlexTable.getCellFormatter().addStyleName(0, 1, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(0, 2, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(0, 3, "watchListRemoveColumn");
		stocksFlexTable.setCellPadding(6);
		
		//Assemble add stock panel
		addPanel.add(newSymbolTextBox);
		addPanel.add(addStockButton);
		addPanel.addStyleName("addPanel");
		
		errorMsgLabel.setStyleName("errorMessage");
		errorMsgLabel.setVisible(false);
		
		//Assemble main panel
		mainPanel.add(errorMsgLabel);
		mainPanel.add(stocksFlexTable);
		mainPanel.add(addPanel);
		mainPanel.add(lastUpdatedLabel);
		
		RootPanel.get("stockList").add(mainPanel);
		
		newSymbolTextBox.setFocus(true);
		
		addStockButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				addStock();
			}
		});
		
		newSymbolTextBox.addKeyPressHandler(new KeyPressHandler() {
			
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER)
					addStock();
			}
		});
		
		Timer refreshTimer = new Timer() {
			
			@Override
			public void run() {
				refreshWatcheList();
			}
		};
		refreshTimer.scheduleRepeating(REFRESH_INTERVAL);
		
	}

	protected void refreshWatcheList() {
		if(stockPriceSvc == null)
			stockPriceSvc = GWT.create(StockPriceService.class);
		
		AsyncCallback<StockPrice[]> callback = new AsyncCallback<StockPrice[]>() {
			
			@Override
			public void onSuccess(StockPrice[] result) {
				updateTable(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				String details = caught.getMessage();
				if(caught instanceof DelistedException)
					details = "Company '" + ((DelistedException)caught).getSymbol() + "' was delisted.";
				errorMsgLabel.setText("Error: " + details);
				errorMsgLabel.setVisible(true);
			}
		};
		
		stockPriceSvc.getPrices(stocks.toArray(new String[0]), callback);
		
	}

	private void updateTable(StockPrice[] prices) {
		for (int i = 0; i < prices.length; i++) {
			updateTable(prices[i]);
		}
		
		lastUpdatedLabel.setText(messages.lastUpdate(new Date()));
		
		errorMsgLabel.setVisible(false);
	}

	private void updateTable(StockPrice price) {
		if(!stocks.contains(price.getSymbol()))
			return;
		
		int row = stocks.indexOf(price.getSymbol()) + 1;
		
		String priceText = NumberFormat.getFormat("#,##0.00").format(price.getPrice());
		NumberFormat changeFormat = NumberFormat.getFormat("+#,##0.00;-#,##0.00");
		String changeText = changeFormat.format(price.getChange());
		String changePercentText = changeFormat.format(price.getChangePercent());
		
		stocksFlexTable.setText(row, 1, priceText);
		Label changeWidget = (Label)stocksFlexTable.getWidget(row, 2);
		changeWidget.setText(changeText + " (" + changePercentText + "%)"); 
		String changeStyleName = "nochange";
		if(price.getChangePercent()<-0.1f) 
			changeStyleName = "negativeChange";
		else if(price.getChangePercent()>0.1f)
			changeStyleName = "positiveChange";
		changeWidget.setStyleName(changeStyleName);
	}

	private void addStock() {
		final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
		newSymbolTextBox.setFocus(true);
		if(!symbol.matches("^[0-9A-Z\\.]{1,10}$")) {
			Window.alert(messages.invalidSymbol(symbol));
			newSymbolTextBox.selectAll();
			return;
		}
		newSymbolTextBox.setText("");
		
		if(stocks.contains(symbol))
			return;
		
		stocks.add(symbol);
		int row = stocksFlexTable.getRowCount();
		stocksFlexTable.setText(row, 0, symbol);
		stocksFlexTable.setWidget(row, 2, new Label());
		
		Button removeButton = new Button("x");
		removeButton.addStyleDependentName("remove");
		removeButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				int index = stocks.indexOf(symbol);
				stocks.remove(index);
				stocksFlexTable.removeRow(index+1);
			}
		});
		stocksFlexTable.setWidget(row, 3, removeButton);
		
		stocksFlexTable.getCellFormatter().addStyleName(row, 1, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(row, 2, "watchListNumericColumn");
		stocksFlexTable.getCellFormatter().addStyleName(row, 3, "watchListRemoveColumn");
		
		refreshWatcheList();
	}
}
