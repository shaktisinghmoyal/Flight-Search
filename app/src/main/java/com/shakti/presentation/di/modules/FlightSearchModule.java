package com.shakti.presentation.di.modules;


import com.shakti.domain.interactor.BaseUseCase;
import com.shakti.domain.interactor.GetFlights;
import com.shakti.presentation.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class FlightSearchModule {

    public FlightSearchModule() {
    }

    @Provides
    @PerActivity
    @Named("getFlights")
    BaseUseCase provideGetFlightUseCase(GetFlights getFlights) {
        return getFlights;
    }


}
