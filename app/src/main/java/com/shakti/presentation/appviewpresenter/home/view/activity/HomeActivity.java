package com.shakti.presentation.appviewpresenter.home.view.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.shakti.R;
import com.shakti.databinding.BookDetailActivityBinding;
import com.shakti.presentation.di.HasComponent;
import com.shakti.presentation.di.components.BookDetailComponent;
import com.shakti.presentation.di.components.DaggerBookDetailComponent;
import com.shakti.presentation.appviewpresenter.base.view.activity.BaseActivity;
import com.shakti.presentation.appviewpresenter.base.view.activity.MainActivity;
import com.shakti.presentation.appviewpresenter.home.presenter.BookActivityPresenter;
import com.shakti.presentation.appviewpresenter.home.view.BookActivityView;
import com.shakti.presentation.appviewpresenter.home.view.fragment.BookDetailFragment;
import com.shakti.presentation.utils.ConfirmationButtonsClickInterface;
import com.shakti.presentation.utils.Util;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements BookActivityView, HasComponent<BookDetailComponent> {
    public static Activity activity;
    private final String Tag = "HomeActivity";
    @Inject
    BookActivityPresenter bookActivityPresenter;
    private Bundle bookDetailBundle;
    private BookDetailComponent bookDetailComponent;
    private BookDetailActivityBinding bookDetailActivityBinding;
    private ColorDrawable colorDrawable;
    private ColorDrawable colorDrawableOpaque;
    private View.OnClickListener buttonClickListners = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookDetailBundle = getIntent().getBundleExtra(Util.bookDetailBundle);
        bookDetailActivityBinding = DataBindingUtil.setContentView(
                this, R.layout.book_detail_activity);
        initializeItems();

    }

    private void initializeItems() {
        initializeInjector();
        activity = bookDetailComponent.activity();
        bookDetailComponent.inject(this);
        bookActivityPresenter.setView(this);
        bookActivityPresenter.initialize();

    }

    private void initializeInjector() {
        this.bookDetailComponent = DaggerBookDetailComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();

    }





    @Override
    public void addBookDetailFragment() {
        BookDetailFragment bookDetailFragment = new BookDetailFragment();
        bookDetailFragment.setArguments(bookDetailBundle);
        navigator.addFragment(this, R.id.book_detail_fragment_container, bookDetailFragment);
    }




    @Override
    public BookDetailComponent getComponent() {
        return bookDetailComponent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}