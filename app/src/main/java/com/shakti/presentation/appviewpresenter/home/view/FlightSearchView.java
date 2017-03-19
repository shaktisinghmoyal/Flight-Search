package com.shakti.presentation.appviewpresenter.home.view;


import android.content.Context;

import com.shakti.presentation.appviewpresenter.home.model.FlightModel;
import com.shakti.presentation.appviewpresenter.home.model.FlightsModel;

public interface FlightSearchView {
    void showMainLayout();

    void hideMainLayout();

    void showLoadingViewForFlights();

    void hideLoadingViewForFlights();

    void showRetryViewForFlights();

    void hideRetryViewForFlights();

    void showErrorViewForFlights(String message);

    void disableErrorViewForFlights();

    void displayFlights(FlightsModel flightsModel);

    void highlightFareSortText();

    void highlightLandingSortText();

    void highlightTakeOffTimeSortText();

    void removeHighlightFareSortText();

    void removeHighlightLandingSortText();

    void removeHighlightTakeOffTimeSortText();

    void showBookingProviders(FlightModel flightModel);

    void setActionBar();

     Context context();

}
