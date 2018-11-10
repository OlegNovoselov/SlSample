package com.makeomatic.sllibrary.presentation.main;

import com.makeomatic.sllibrary.R;
import com.makeomatic.sllibrary.domain.menu.GetMenuInteractor;
import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.presentation.common.BasePresenter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by OLEG on 10.11.2018.
 */

public class MainPresenter extends BasePresenter<MainView> {

    private final GetMenuInteractor getMenuInteractor;

    @Inject
    public MainPresenter(GetMenuInteractor getMenuInteractor) {
        this.getMenuInteractor = getMenuInteractor;
    }

    @Override
    public void onStart() {
        getMenuInteractor.execute(new DisposableObserver<List<Menu>>() {
            @Override
            public void onNext(List<Menu> menus) {
                getView().setMenu(menus);
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
        getMenuInteractor.unsubscribe();
    }
}
