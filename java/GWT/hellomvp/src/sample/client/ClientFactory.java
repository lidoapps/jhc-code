package sample.client;

import sample.client.view.GoodbyeView;
import sample.client.view.HelloView;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {

	EventBus getEventBus();
	PlaceController getPlaceController();
	HelloView getHelloView();
	GoodbyeView getGoodbyeView(); 
}
