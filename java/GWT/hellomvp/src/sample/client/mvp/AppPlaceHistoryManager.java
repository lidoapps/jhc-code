package sample.client.mvp;

import sample.client.place.GoodbyePlace;
import sample.client.place.HelloPlace;
import sample.client.place.GoodbyePlace.Tokenizer;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({GoodbyePlace.Tokenizer.class, HelloPlace.Tokenizer.class})
public interface AppPlaceHistoryManager extends PlaceHistoryMapper {

}
