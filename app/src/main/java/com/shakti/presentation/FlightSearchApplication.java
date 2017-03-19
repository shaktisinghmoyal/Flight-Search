package com.shakti.presentation;

import android.app.Application;
import android.content.Context;

import com.shakti.presentation.di.components.ApplicationComponent;
import com.shakti.presentation.di.components.DaggerApplicationComponent;
import com.shakti.presentation.di.modules.ApplicationModule;

public class FlightSearchApplication extends Application {

    private static ApplicationComponent applicationComponent;
    private final String Tag = "FlightSearchApplication";

    public static Context getAppContext() {
        return applicationComponent.context();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }


}
