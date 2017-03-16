
package com.shakti.presentation.di.components;

import android.content.Context;

import com.shakti.domain.executor.PostExecutionThread;
import com.shakti.domain.executor.ThreadExecutor;
import com.shakti.domain.repository.IHomeRepository;
import com.shakti.presentation.di.modules.ApplicationModule;
import com.shakti.presentation.appviewpresenter.base.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    IHomeRepository homeRepository();


}
