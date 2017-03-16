package com.shakti.presentation.di.modules;


import com.shakti.domain.interactor.BaseUseCase;
import com.shakti.domain.interactor.GetFlights;
import com.shakti.presentation.di.PerActivity;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class LeadCaptureModule {

    public LeadCaptureModule() {
    }

    @Provides
    @PerActivity
    @Named("getFlightModels")
    BaseUseCase provideSaveRecentSearchesBaseUseCase(GetFlights getFlights) {
        return getFlights;
    }


}
