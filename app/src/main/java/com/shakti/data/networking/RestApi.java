package data.entity.mapper.flights.networking;

import com.talentica.data.entity.BookEntity;

import java.util.List;

import rx.Observable;

public interface RestApi extends BaseURL {
    //for book report operations
    String API_RECENTLY_ADDED_BOOK = API_BASE_URL + API_SEPERATOR + "recently-added";




    Observable<String> callSignInApi(String username, String password);



}
