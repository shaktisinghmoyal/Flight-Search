package com.shakti.presentation.appviewpresenter.home.view;

public interface BookingProviderView {

    void showLoadingViewForBookingProviders();

    void hideLoadingViewForBookingProviders();

    void showRetryViewForBookingProviders();

    void hideRetryViewForBookingProviders();

    void showErrorViewForBookingProvider(String message);

    void disableErrorViewForBookingProvider();

    void displaySortedBookingProviders();

    void setActionBar();
}
