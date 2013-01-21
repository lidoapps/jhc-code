package sample.client.view;

import sample.client.place.GoodbyePlace;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class HelloViewImpl extends Composite implements HelloView {

	private static HelloViewImplUiBinder uiBinder = GWT
			.create(HelloViewImplUiBinder.class);

	interface HelloViewImplUiBinder extends UiBinder<Widget, HelloViewImpl> {
	}

	@UiField
	SpanElement nameSpan;
	@UiField
	Anchor goodbyeLink;
	
	private String name;
	private Presenter presenter;
	
	public HelloViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public HelloViewImpl(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setName(String helloName) {
		this.name = helloName;
		nameSpan.setInnerText(helloName);
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("goodbyeLink")
	void onClickGoodbyeLink(ClickEvent e) {
		presenter.goTo(new GoodbyePlace(name));
	}
}
