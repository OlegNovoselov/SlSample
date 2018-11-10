package com.makeomatic.sllibrary.presentation.action;

import com.makeomatic.sllibrary.R;
import com.makeomatic.sllibrary.domain.demo.DemoItem;
import com.makeomatic.sllibrary.domain.demo.GetDemoItemInteractor;
import com.makeomatic.sllibrary.domain.menu.GetMenuInteractor;
import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.presentation.common.BasePresenter;
import com.makeomatic.sllibrary.presentation.main.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by OLEG on 10.11.2018.
 */

public class Action1Presenter extends BasePresenter<DemoView> {
    private final GetDemoItemInteractor interactor;

    @Inject
    public Action1Presenter(GetDemoItemInteractor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void onStart() {
        interactor.execute(new DisposableObserver<List<DemoItem>>() {
            @Override
            public void onNext(List<DemoItem> items) {
                getView().setItems(items);
            }

            @Override
            public void onError(Throwable e) {
                getView().showError(R.string.error);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onStop() {

    }
}
