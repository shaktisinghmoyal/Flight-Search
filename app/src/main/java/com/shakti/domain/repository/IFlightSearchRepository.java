package com.shakti.domain.repository;


import com.shakti.domain.model.Flights;

import java.util.List;

import rx.Observable;

public interface IFlightSearchRepository {


    Observable<Flights> getFlights();

}
