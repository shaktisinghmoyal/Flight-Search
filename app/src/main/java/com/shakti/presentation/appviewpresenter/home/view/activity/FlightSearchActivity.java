package com.shakti.presentation.appviewpresenter.home.view.activity;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.shakti.R;
import com.shakti.databinding.ActivityFlightSearchBinding;
import com.shakti.presentation.appviewpresenter.home.model.FlightModel;
import com.shakti.presentation.appviewpresenter.home.model.FlightsModel;
import com.shakti.presentation.appviewpresenter.home.presenter.FlightSearchPresenter;
import com.shakti.presentation.appviewpresenter.home.view.FlightSearchView;
import com.shakti.presentation.appviewpresenter.base.view.activity.BaseActivity;

import com.shakti.presentation.appviewpresenter.home.view.adapter.FlightsAdapter;
import com.shakti.presentation.di.HasComponent;
import com.shakti.presentation.di.components.DaggerFlightSearchComponent;
import com.shakti.presentation.di.components.FlightSearchComponent;

import javax.inject.Inject;


public class FlightSearchActivity extends BaseActivity implements FlightSearchView,
        HasComponent<FlightSearchComponent> {
    public static Activity activity;
    private final String Tag = "FlightSearchActivity";
    @Inject
    FlightSearchPresenter flightSearchPresenter;
    @Inject
    FlightsAdapter flightsRecyclerViewAdapter;
    RecyclerView flightsRecyclerView;
    private FlightSearchComponent flightSearchComponent;

    @Override
    public Context context() {
        return null;
    }

    private ActivityFlightSearchBinding flightSearchActivityBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        flightSearchActivityBinding = DataBindingUtil.setContentView(
                this, R.layout.activity_flight_search);
        initializeInjector();
        initializeViews();
        flightSearchComponent.inject(this);
        flightSearchPresenter.setView(this);
        flightSearchPresenter.initialize();

    }

    private void initializeViews() {
        flightSearchActivityBinding.sortByFare.setOnClickListener(clickListners);
        flightSearchActivityBinding.takeOffTimeSort.setOnClickListener(clickListners);
        flightSearchActivityBinding.landingTimeSort.setOnClickListener(clickListners);
        flightSearchActivityBinding.viewRetry.setOnClickListener(clickListners);
        flightsRecyclerView=flightSearchActivityBinding.flightsRecyclerView;
        flightsRecyclerView.setLayoutManager(new LinearLayoutManager(this
                .getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        flightsRecyclerView.setAdapter(flightsRecyclerViewAdapter);
    }

    private void initializeInjector() {
        this.flightSearchComponent = DaggerFlightSearchComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

    }


    @Override
    public void displayFlights(FlightsModel flightsModel) {
        flightsRecyclerViewAdapter.setFlights(flightsModel.getFlightModels());
    }

    @Override
    public void highlightFareSortText() {
        flightSearchActivityBinding.sortByFare.setTextColor(Color.parseColor("#B22222"));
    }

    @Override
    public void highlightLandingSortText() {
        flightSearchActivityBinding.landingTimeSort.setTextColor(Color.parseColor("#B22222"));
    }

    @Override
    public void highlightTakeOffTimeSortText() {
        flightSearchActivityBinding.takeOffTimeSort.setTextColor(Color.parseColor("#B22222"));
    }

    @Override
    public void removeHighlightFareSortText() {
        flightSearchActivityBinding.sortByFare.setTextColor(Color.parseColor("#808080"));
    }

    @Override
    public void removeHighlightLandingSortText() {
        flightSearchActivityBinding.landingTimeSort.setTextColor(Color.parseColor("#808080"));
    }

    @Override
    public void removeHighlightTakeOffTimeSortText() {
        flightSearchActivityBinding.takeOffTimeSort.setTextColor(Color.parseColor("#808080"));
    }

    @Override
    public void showBookingProviders(FlightModel flightModel) {

    }

    @Override
    public void setActionBar() {

    }

    private FlightsAdapter.OnItemClickListener onFlightClickListener =
            new FlightsAdapter.OnItemClickListener() {
                @Override
                public void onFlightClicked(FlightModel flightModel) {
                    if (flightSearchPresenter != null && flightModel != null) {
                        flightSearchPresenter.onFlightClicked(flightModel);
                    }
                }

            };


    private View.OnClickListener clickListners = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

                case R.id.take_off_time_sort:
                    flightSearchPresenter.onSortByTakeOffTimeClicked();
                break;

                case R.id.landing_time_sort:
                    flightSearchPresenter.onSortByLandingTimeClicked();

                break;

                case R.id.view_retry:
                    flightSearchPresenter.tryAgain();

                break;


            }

        }
    };


    @Override
    public FlightSearchComponent getComponent() {
        return flightSearchComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        flightSearchPresenter.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        flightSearchPresenter.pause();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        flightSearchPresenter.destroy();
        flightsRecyclerView.setAdapter(null);
    }


    @Override
    public void showMainLayout() {
        flightSearchActivityBinding.mainView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideMainLayout() {
        flightSearchActivityBinding.mainView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showLoadingViewForFlights() {
        flightSearchActivityBinding.fetchingBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoadingViewForFlights() {
        flightSearchActivityBinding.fetchingBar.setVisibility(View.GONE);
    }

    @Override
    public void showRetryViewForFlights() {
        flightSearchActivityBinding.viewRetry.setVisibility(View.VISIBLE);
        flightSearchActivityBinding.emptyViewText.setText(R.string.try_again);
    }

    @Override
    public void hideRetryViewForFlights() {
        flightSearchActivityBinding.viewRetry.setVisibility(View.GONE);
    }

    @Override
    public void showErrorViewForFlights(String message) {
        flightSearchActivityBinding.viewRetry.setVisibility(View.VISIBLE);
        flightSearchActivityBinding.errorTextView.setText(message);
    }

    @Override
    public void disableErrorViewForFlights() {
        flightSearchActivityBinding.viewRetry.setVisibility(View.GONE);
    }


}
