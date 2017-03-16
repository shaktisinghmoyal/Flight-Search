package com.shakti.presentation.appviewpresenter.base.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.shakti.presentation.BookShelfApplication;
import com.shakti.presentation.di.components.ApplicationComponent;
import com.shakti.presentation.di.modules.ActivityModule;
import com.shakti.presentation.navigation.Navigator;

public abstract class BaseActivity extends AppCompatActivity {

    private final String Tag = "BaseActivity";
    // @Inject
    public Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
        navigator = new Navigator();
    }

//     protected  void setActionBar(){};
//    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
//
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        if (tag == "search_fragment") {
//            fragmentTransaction.replace(containerViewId, fragment, tag).addToBackStack(tag);
//        } else {
//            fragmentTransaction.replace(containerViewId, fragment, tag);
//        }
//        fragmentTransaction.commitAllowingStateLoss();
//    }

    /**
     * Get the Main Application component for dependency injection.
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((BookShelfApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }


}
