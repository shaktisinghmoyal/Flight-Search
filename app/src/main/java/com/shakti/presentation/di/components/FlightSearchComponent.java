package com.shakti.presentation.di.components;

import com.shakti.presentation.appviewpresenter.home.view.activity.BookingProviderActivity;
import com.shakti.presentation.appviewpresenter.home.view.activity.FlightSearchActivity;
import com.shakti.presentation.di.PerActivity;
import com.shakti.presentation.di.modules.ActivityModule;
import com.shakti.presentation.di.modules.FlightSearchModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, FlightSearchModule.class})
public interface FlightSearchComponent extends ActivityComponent {
    void inject(FlightSearchActivity mainActivity);
    void inject(BookingProviderActivity bookingProviderActivity);


}
