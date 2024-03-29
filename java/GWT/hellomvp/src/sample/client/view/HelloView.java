package sample.client.view;


import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface HelloView extends IsWidget {
	void setName(String helloName);
	void setPresenter(Presenter presenter);
	public interface Presenter{
		void goTo(Place place);
	}
}
