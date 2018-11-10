package com.makeomatic.sllibrary.domain.menu;

import com.makeomatic.sllibrary.domain.common.Interactor;
import com.makeomatic.sllibrary.presentation.di.DomainModule;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * Created by OLEG on 10.11.2018.
 */

public class GetMenuInteractor extends Interactor<List<Menu>, Void> {
    private final MenuDataProvider menuDataProvider;

    @Inject
    public GetMenuInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                             @Named(DomainModule.UI) Scheduler iuScheduler,
                             MenuDataProvider menuDataProvider) {
        super(jobScheduler, iuScheduler);
        this.menuDataProvider = menuDataProvider;
    }

    @Override
    protected Observable<List<Menu>> buildObservable(Void parameter) {
        return menuDataProvider.getAllItems();
    }
}
