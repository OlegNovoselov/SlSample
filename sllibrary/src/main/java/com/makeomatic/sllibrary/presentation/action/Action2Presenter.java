package com.makeomatic.sllibrary.presentation.action;

import com.makeomatic.sllibrary.R;
import com.makeomatic.sllibrary.domain.demo.DemoItem;
import com.makeomatic.sllibrary.domain.demo.GetDemoItemInteractor;
import com.makeomatic.sllibrary.presentation.common.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by OLEG on 10.11.2018.
 */

public class Action2Presenter extends BasePresenter<DemoView> {
    private final GetDemoItemInteractor interactor;

    @Inject
    public Action2Presenter(GetDemoItemInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {

    }
}
