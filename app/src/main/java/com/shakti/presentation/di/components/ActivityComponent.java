
package com.shakti.presentation.di.components;


import android.support.v7.app.AppCompatActivity;

import com.shakti.presentation.di.PerActivity;
import com.shakti.presentation.di.modules.ActivityModule;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:

 */
@PerActivity
@Component(dependencies = com.shakti.presentation.di.components.ApplicationComponent.class,
        modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    AppCompatActivity activity();
}
