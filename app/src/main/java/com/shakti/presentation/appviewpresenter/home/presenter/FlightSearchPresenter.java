package com.shakti.presentation.appviewpresenter.home.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.shakti.domain.interactor.BaseUseCase;
import com.shakti.domain.interactor.DefaultSubscriber;
import com.shakti.domain.model.Flights;
import com.shakti.presentation.appviewpresenter.base.presenter.Presenter;
import com.shakti.presentation.appviewpresenter.home.model.FlightModel;
import com.shakti.presentation.appviewpresenter.home.model.FlightsModel;
import com.shakti.domain.exception.DefaultErrorBundle;
import com.shakti.domain.exception.ErrorBundle;

import com.shakti.presentation.appviewpresenter.home.view.FlightSearchView;
import com.shakti.presentation.exception.ErrorMessageFactory;
import com.shakti.presentation.di.PerActivity;
import com.shakti.presentation.mapper.DataMapper;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class FlightSearchPresenter implements IFlightSearchPresenter, Presenter {

    private final String Tag = "FlightSearchPresenter";
    private final BaseUseCase getFlights;
    private final DataMapper dataMapper;
    private FlightSearchView flightSearchView;
    private FlightsModel flightsModel;
    private FlightsModel flightsModelSortedByFare;
    private FlightsModel flightsModelSortedByTakeOffTime;
    private FlightsModel flightsModelSortedByLandingTime;

    @Inject
    public FlightSearchPresenter(@Named("getFlights") BaseUseCase getFlights, DataMapper dataMapper) {
        this.getFlights = getFlights;
        this.dataMapper = dataMapper;

    }

    public void setView(@NonNull FlightSearchView flightSearchView) {
        this.flightSearchView = flightSearchView;

    }

    /**
     * Initializes the presenter by start retrieving the FlightsEntity list.
     */
    public void initialize() {
        setActionBar();
        fetchData();
    }


    public void tryAgain() {
        fetchData();
    }

    public void  fetchData(){
        hideViewRetry();
        showViewLoading();
        getFlights();
    }

    private void setActionBar() {
        flightSearchView.setActionBar();
    }

    private void showViewLoading() {
        flightSearchView.showLoadingViewForFlights();

    }

    private void hideViewLoading() {
        flightSearchView.hideLoadingViewForFlights();
    }


    private void hideViewRetry() {
        flightSearchView.hideRetryViewForFlights();
    }

    private void showViewRetry() {
        flightSearchView.showRetryViewForFlights();
    }

    private void showMainLayout() {
        flightSearchView.showMainLayout();
    }

    private void highMainLayout() {
        flightSearchView.hideMainLayout();
    }

    private void showErrorMessage(ErrorBundle errorBundle) {
        String errorMessage = ErrorMessageFactory.create(flightSearchView.context(),
                errorBundle.getException());
        this.flightSearchView.showErrorViewForFlights(errorMessage);
    }


    private void showFlights(FlightsModel flightsModel) {
        flightSearchView.displayFlights(flightsModel);
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        getFlights.unsubscribe();
        this.flightSearchView = null;
    }

    @Override
    public void getFlights() {
        getFlights.execute(new FlightListSubscriber());
    }

    @Override
    public void onSortByFareClicked() {
        flightSearchView.highlightFareSortText();
        flightSearchView.removeHighlightLandingSortText();
        flightSearchView.removeHighlightTakeOffTimeSortText();
        flightSearchView.displayFlights(flightsModelSortedByFare);
    }

    @Override
    public void onSortByTakeOffTimeClicked() {
        flightSearchView.highlightTakeOffTimeSortText();
        flightSearchView.removeHighlightLandingSortText();
        flightSearchView.removeHighlightFareSortText();
        flightSearchView.displayFlights(flightsModelSortedByTakeOffTime);
    }

    @Override
    public void onSortByLandingTimeClicked() {
        flightSearchView.removeHighlightFareSortText();
        flightSearchView.highlightLandingSortText();
        flightSearchView.removeHighlightTakeOffTimeSortText();
        flightSearchView.displayFlights(flightsModelSortedByLandingTime);
    }

    @Override
    public void onFlightClicked(FlightModel flightModel) {

        flightSearchView.showBookingProviders( flightModel);

    }

    private FlightsModel shortFlights(FlightsModel flightsModel) {

        return flightsModel;
    }

    private final class FlightListSubscriber extends DefaultSubscriber<Flights> {


        @Override
        public void onCompleted() {
            hideViewLoading();
        }

        @Override
        public void onError(Throwable e) {
            showErrorMessage(new DefaultErrorBundle((Exception) e));
            hideViewLoading();
            showViewRetry();
        }

        @Override
        public void onNext(Flights flights) {
            flightsModel = dataMapper.transform(flights);
            flightsModelSortedByFare = shortFlights(flightsModel);
            flightsModelSortedByTakeOffTime = shortFlights(flightsModel);
            flightsModelSortedByLandingTime = shortFlights(flightsModel);
            showFlights(flightsModelSortedByFare);
            hideViewLoading();
            showMainLayout();
            flightSearchView.highlightFareSortText();
        }
    }
}
