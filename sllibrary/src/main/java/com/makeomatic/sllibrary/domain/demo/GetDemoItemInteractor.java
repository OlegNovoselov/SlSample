package com.makeomatic.sllibrary.domain.demo;

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

public class GetDemoItemInteractor  extends Interactor<List<DemoItem>, Void> {
    private final DemoItemProvider demoItemProvider;

    @Inject
    public GetDemoItemInteractor(@Named(DomainModule.JOB) Scheduler jobScheduler,
                             @Named(DomainModule.UI) Scheduler iuScheduler,
                             DemoItemProvider demoItemProvider) {
        super(jobScheduler, iuScheduler);
        this.demoItemProvider = demoItemProvider;
    }

    @Override
    protected Observable<List<DemoItem>> buildObservable(Void parameter) {
        return demoItemProvider.getAllItems();
    }
}
