package sample.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class GoodbyePlace extends Place {
	private String goodbyeName;

	public GoodbyePlace(String name) {
		this.goodbyeName = name;
	}

	public String getGoodbyeName() {
		return goodbyeName;
	}

	public static class Tokenizer implements PlaceTokenizer<GoodbyePlace> {
		@Override
		public String getToken(GoodbyePlace place) {
			return place.getGoodbyeName();
		}

		@Override
		public GoodbyePlace getPlace(String token) {
			return new GoodbyePlace(token);
		}
	}
}
