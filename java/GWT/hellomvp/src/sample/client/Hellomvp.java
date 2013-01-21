package sample.client;

import sample.client.mvp.AppActivityMapper;
import sample.client.mvp.AppPlaceHistoryManager;
import sample.client.place.HelloPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Hellomvp implements EntryPoint {
	
	private Place defaultPlace = new HelloPlace("World!");
	private SimplePanel appWidget = new SimplePanel();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ClientFactory clientFactory = GWT.create(ClientFactoryImpl.class);
		EventBus eventBus = clientFactory.getEventBus();
		PlaceController placeController = clientFactory.getPlaceController();
		
		ActivityMapper mapper = new AppActivityMapper(clientFactory);
		ActivityManager manager = new ActivityManager(mapper, eventBus);
		manager.setDisplay(appWidget);
		
		AppPlaceHistoryManager historyManager = GWT.create(AppPlaceHistoryManager.class);
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyManager);
		historyHandler.register(placeController, eventBus, defaultPlace);
		
		RootPanel.get().add(appWidget);
		historyHandler.handleCurrentHistory();
	}
}
