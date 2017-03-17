package com.shakti.presentation.appviewpresenter.home.view;


public interface FlightSearchView {
    void showLoadingView();

    void hideLoadingView();

    void showRetryView();

    void hideRetryView();

    void showErrorView(String message);

    void disableErrorView();

    void displayFlightsSortedByFare();

    void displayFlightsSortedByTakeOffTime();

    void displayFlightsSortedByFare();

}
