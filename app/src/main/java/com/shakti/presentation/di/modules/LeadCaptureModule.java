package com.shakti.presentation.di.modules;


import com.shakti.domain.usecases.BaseUseCase;
import com.shakti.domain.usecases.GetBooksGridResults;
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
    @Named("saveRecentSearches")
    BaseUseCase provideSaveRecentSearchesBaseUseCase(SaveRecentSearches saveRecentSearches) {
        return saveRecentSearches;
    }


}
