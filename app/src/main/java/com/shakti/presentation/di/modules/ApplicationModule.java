
package com.shakti.presentation.di.modules;

import android.content.Context;

import com.shakti.data.executor.JobExecutor;
import com.shakti.data.repository.FlightSearchRepository;

import com.shakti.domain.executor.PostExecutionThread;
import com.shakti.domain.executor.ThreadExecutor;

import com.shakti.domain.repository.IFlightSearchRepository;

import com.shakti.presentation.FlightSearchApplication;
import com.shakti.presentation.UIThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
    private final FlightSearchApplication application;

    public ApplicationModule(FlightSearchApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    IFlightSearchRepository provideIFlightSearchRepository(FlightSearchRepository flightSearchRepository) {
        return flightSearchRepository;
    }


}

