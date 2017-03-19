package com.shakti.data.networking;




import com.shakti.data.entity.FlightsEntity;

import java.util.List;

import rx.Observable;

public interface IRestApi extends BaseURL {

    /**
     * Retrieves an {@link Observable} which will emit a List of {@link FlightsEntity}.
     */
    Observable<FlightsEntity> getFlightsList();



}
