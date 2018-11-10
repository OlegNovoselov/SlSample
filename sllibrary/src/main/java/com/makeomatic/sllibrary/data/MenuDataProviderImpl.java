package com.makeomatic.sllibrary.data;

import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.domain.menu.MenuDataProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by OLEG on 10.11.2018.
 */

public class MenuDataProviderImpl implements MenuDataProvider {
    @Override
    public Observable<List<Menu>> getAllItems() {
        List<Menu> result = new ArrayList<>();

        result.add(new Menu("1", "icon1", "action1"));
        result.add(new Menu("2", "icon2", "action2"));
        result.add(new Menu("3", "icon2", "action3"));
        result.add(new Menu("4", "icon1","action4"));

        return Observable.just(result);
    }
}
