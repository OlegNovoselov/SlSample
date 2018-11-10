package com.makeomatic.sllibrary.domain.common;

import org.reactivestreams.Subscriber;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by OLEG on 10.11.2018.
 */

public abstract class Interactor<ResultType, ParameterType> {
    private final CompositeDisposable disposables = new CompositeDisposable();
    protected final Scheduler jobScheduler;
    private final Scheduler uiScheduler;

    public Interactor(Scheduler jobScheduler, Scheduler uiScheduler) {
        this.jobScheduler = jobScheduler;
        this.uiScheduler = uiScheduler;
    }

    protected abstract Observable<ResultType> buildObservable(ParameterType parameter);

    public void execute(ParameterType parameter, DisposableObserver<ResultType> subscriber) {
        buildObservable(parameter)
                .subscribeOn(jobScheduler)
                .observeOn(uiScheduler)
                .subscribe(subscriber);
    }

    public void execute(DisposableObserver<ResultType> subscriber) {
        execute(null, subscriber);
    }

    public void unsubscribe() {
        disposables.clear();
    }
}
