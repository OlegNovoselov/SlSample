package com.makeomatic.sllibrary.presentation.di;

import com.makeomatic.sllibrary.data.DemoDataProviderImpl;
import com.makeomatic.sllibrary.data.MenuDataProviderImpl;
import com.makeomatic.sllibrary.domain.demo.DemoItemProvider;
import com.makeomatic.sllibrary.domain.menu.MenuDataProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by OLEG on 10.11.2018.
 */

@Module
public class DataModule {

    @Singleton
    @Provides
    public MenuDataProvider provideMenuDataProvider() {
        return new MenuDataProviderImpl();
    }

    @Singleton
    @Provides
    public DemoItemProvider provideDemoItemProvider() {
        return new DemoDataProviderImpl();
    }
}
