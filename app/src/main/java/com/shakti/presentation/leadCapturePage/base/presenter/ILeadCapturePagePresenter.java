package com.shakti.presentation.leadCapturePage.base.presenter;

public interface ILeadCapturePagePresenter {

    // this function wil be used to navigate between fragments for bottom menu item click

    void getCurrentPage();

    void saveForRecentSearches(String recentSearches);
}
