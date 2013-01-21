package sample.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class HelloPlace extends Place {

	private String helloName;

	public HelloPlace(String token) {
		super();
		this.helloName = token;
	}

	public String getHelloName() {
		return this.helloName;
	}

	public static class Tokenizer implements PlaceTokenizer<HelloPlace> {
		@Override
		public String getToken(HelloPlace place) {
			return place.getHelloName();
		}

		@Override
		public HelloPlace getPlace(String token) {
			return new HelloPlace(token);
		}
	}

}
