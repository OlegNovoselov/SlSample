package com.makeomatic.sllibrary.presentation.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.makeomatic.sllibrary.presentation.main.MainRouter;

import java.lang.annotation.Annotation;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by OLEG on 10.11.2018.
 */

public abstract class BaseFragment extends Fragment {
    private static final AtomicInteger lastFragmentId = new AtomicInteger(0);
    private final int fragmentId;
    private MainRouter mainRouter;
    private View rootView;

    public BaseFragment() {
        fragmentId = lastFragmentId.incrementAndGet();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutView(), null);
        return rootView;
    }

    protected abstract int getLayoutView();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inject();
        getPresenter().setView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public String getFragmentName() {
        return Long.toString(fragmentId);
    }

    @NonNull
    protected abstract BasePresenter getPresenter();

    protected abstract void inject();

    protected MainRouter getRouter() {
        return mainRouter;
    }

    public void setRouter(MainRouter mainRouter) {
        this.mainRouter = mainRouter;
    }

    protected View getRootView() {
        return rootView;
    }

}
