package sample.client;

import sample.client.view.GoodbyeView;
import sample.client.view.GoodbyeViewImpl;
import sample.client.view.HelloView;
import sample.client.view.HelloViewImpl;

import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {
    private final EventBus eventBus = new SimpleEventBus();
    private final PlaceController placeController = new PlaceController(eventBus);
    private final HelloView helloView = new HelloViewImpl();
    private final GoodbyeView goodbyeView = new GoodbyeViewImpl();

	@Override
	public EventBus getEventBus() {
		return this.eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return this.placeController;
	}

	@Override
	public HelloView getHelloView() {
		return this.helloView;
	}

	@Override
	public GoodbyeView getGoodbyeView() {
		return this.goodbyeView;
	}

}
