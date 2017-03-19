package com.shakti.presentation.appviewpresenter.home.presenter;


import com.shakti.presentation.appviewpresenter.home.model.FlightModel;

public interface IFlightSearchPresenter {

    void getFlights();

    void onSortByFareClicked();

    void onSortByTakeOffTimeClicked();

    void onSortByLandingTimeClicked();

    void onFlightClicked(FlightModel flightModel);
}
