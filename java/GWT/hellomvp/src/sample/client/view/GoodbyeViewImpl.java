package sample.client.view;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

public class GoodbyeViewImpl extends Composite implements GoodbyeView {

	SimplePanel panel = new SimplePanel();
	Element nameSpan = DOM.createSpan();
	
	public GoodbyeViewImpl() {
		panel.getElement().appendChild(nameSpan);
		initWidget(panel);
	}

	@Override
	public void setName(String goodbyName) {
		nameSpan.setInnerText("Goodbye, " + goodbyName);
	}

}
