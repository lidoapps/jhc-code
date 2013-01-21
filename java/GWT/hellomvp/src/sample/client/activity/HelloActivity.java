package sample.client.activity;

import sample.client.ClientFactory;
import sample.client.place.HelloPlace;
import sample.client.view.HelloView;
import sample.client.view.HelloView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class HelloActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private String name;

	public HelloActivity(ClientFactory clientFactory, HelloPlace place) {
		super();
		this.clientFactory = clientFactory;
		this.name = place.getHelloName();
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		HelloView helloView = clientFactory.getHelloView();
		helloView.setName(name);
		helloView.setPresenter(this);
		panel.setWidget(helloView.asWidget());
	}

	@Override
	public String mayStop() {
		return "Please hold on. This activity is stopping.";
	}

	@Override
	public void goTo(Place place) {
		clientFactory.getPlaceController().goTo(place);
	}

}
