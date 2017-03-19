package com.shakti.data.networking;


import android.content.Context;
import android.util.Log;

import com.shakti.data.entity.FlightsEntity;
import com.shakti.data.entity.mapper.JsonToEntityMapper;
import com.shakti.data.exception.NetworkConnectionException;
import com.shakti.data.networking.libraries.okhttp.ApiConnection;

import java.net.MalformedURLException;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.Subscriber;

@Singleton
public class RestApi extends BaseMethodsForApiRestCalls implements IRestApi, BaseURL {
    private final String Tag = "RestApi";
    private final Context context;
    private JsonToEntityMapper jsonToEntityMapper;


    @Inject
    public RestApi(Context context, JsonToEntityMapper jsonToEntityMapper) {
        if (context == null || jsonToEntityMapper == null) {
            throw new IllegalArgumentException("The constructor parameters cannot be null!!!");
        }
        this.context = context.getApplicationContext();
        this.jsonToEntityMapper = jsonToEntityMapper;
    }


    public Observable<FlightsEntity> getFlightsList() {
        return Observable.create(new Observable.OnSubscribe<FlightsEntity>() {

            @Override
            public void call(Subscriber<? super FlightsEntity> subscriber) {
                if (isThereInternetConnection()) {
                    try {
                        String responseFlights = getFlightsFromApi();
                        if(responseFlights!=null){
                            subscriber.onNext(jsonToEntityMapper.transformFlightsEntity(
                                    responseFlights));
                            subscriber.onCompleted();
                        }
                        else {
                            subscriber.onError(new NetworkConnectionException());
                        }


                    } catch (Exception e) {
                        subscriber.onError(new NetworkConnectionException(e.getMessage()));
                    }
                } else {
                    subscriber.onError(new NetworkConnectionException());
                }
            }
        });

    }
    private String getFlightsFromApi() throws MalformedURLException {
        return ApiConnection.createGET(API_FLIGHT_SEARCH_URL).requestSyncCall();
    }
}
