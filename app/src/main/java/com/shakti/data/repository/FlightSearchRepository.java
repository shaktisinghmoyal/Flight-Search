package com.shakti.data.repository;



import com.shakti.data.entity.FlightsEntity;
import com.shakti.data.entity.mapper.EntityToDataMapper;
import com.shakti.data.networking.RestApi;
import com.shakti.domain.model.Flights;
import com.shakti.domain.repository.IFlightSearchRepository;


import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;


public class FlightSearchRepository implements IFlightSearchRepository {

    private final String Tag = "FlightSearchRepository";
    private RestApi restApi;
    private EntityToDataMapper dataMapper;

    @Inject
    public FlightSearchRepository(RestApi restApi,EntityToDataMapper dataMapper) {
        this.dataMapper=dataMapper;
        this.restApi = restApi;

    }

    @Override
    public Observable<Flights> getFlights() {
        return restApi.getFlightsList().map(new Func1<FlightsEntity,
                Flights>() {
            @Override
            public Flights call(FlightsEntity flightsEntity) {
                return dataMapper.transformFromFlightsEntity(flightsEntity);
            }
        });
    }


}
