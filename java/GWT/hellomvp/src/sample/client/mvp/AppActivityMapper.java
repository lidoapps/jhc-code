package sample.client.mvp;

import sample.client.ClientFactory;
import sample.client.activity.GoodbyeActivity;
import sample.client.activity.HelloActivity;
import sample.client.place.GoodbyePlace;
import sample.client.place.HelloPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;
	
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	@Override
	public Activity getActivity(Place place) {
        if (place instanceof HelloPlace)
            return new HelloActivity(clientFactory, (HelloPlace) place );
        else if (place instanceof GoodbyePlace)
            return new GoodbyeActivity(clientFactory, (GoodbyePlace) place );
        return null;
	}

}
