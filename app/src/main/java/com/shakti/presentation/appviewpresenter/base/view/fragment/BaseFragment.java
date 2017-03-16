package com.shakti.presentation.appviewpresenter.base.view.fragment;


import android.support.v4.app.Fragment;

import com.shakti.presentation.di.HasComponent;

public class BaseFragment extends Fragment {
    private final String Tag = "BaseFragment";

    /**
     * Gets a component for dependency injection by its type.
     */

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
