package com.shakti.presentation.di.components;

import com.shakti.presentation.di.PerActivity;
import com.shakti.presentation.di.modules.ActivityModule;
import com.shakti.presentation.di.modules.LeadCaptureModule;
import com.shakti.presentation.appviewpresenter.base.view.activity.MainActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, LeadCaptureModule.class})
public interface LeadCaptureComponent extends ActivityComponent {
    void inject(MainActivity mainActivity);


}
