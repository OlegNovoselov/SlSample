package com.makeomatic.sllibrary.presentation.di;

import com.makeomatic.sllibrary.presentation.action.Action1Fragment;
import com.makeomatic.sllibrary.presentation.action.Action2Fragment;
import com.makeomatic.sllibrary.presentation.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by OLEG on 10.11.2018.
 */

@Singleton
@Component(modules = {DomainModule.class, DataModule.class})
public interface MainActivityComponent {
    void inject(Action1Fragment action1Fragment);
    void inject(Action2Fragment action2Fragment);

    MainPresenter mainPresenter();
}
