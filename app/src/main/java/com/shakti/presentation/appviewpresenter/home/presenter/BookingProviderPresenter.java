package com.shakti.presentation.appviewpresenter.home.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.shakti.domain.interactor.BaseUseCase;
import com.shakti.presentation.appviewpresenter.base.presenter.Presenter;
import com.shakti.presentation.appviewpresenter.home.view.BookingProviderView;
import com.shakti.presentation.mapper.DataMapper;

import javax.inject.Inject;
import javax.inject.Named;

public class BookingProviderPresenter implements IBookingProviderPresenter, Presenter {


    private final String Tag = "BookingProviderPresenter";
    private BookingProviderView bookingProviderView;

    @Inject
    public BookingProviderPresenter() {

    }


    public void setView(@NonNull BookingProviderView bookingProviderView) {
        this.bookingProviderView = bookingProviderView;

    }

    /**
     * Initializes the presenter by start retrieving the Booking Provider's list.
     */
    public void initialize() {
        setActionBar();


    }

    private void setActionBar() {

    }




    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {
        bookingProviderView=null;
    }

    @Override
    public void showBookingProviders() {

    }

    @Override
    public void onBookingProviderClicked() {

    }
}
