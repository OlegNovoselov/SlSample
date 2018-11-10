package com.makeomatic.sllibrary.domain.menu;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by OLEG on 10.11.2018.
 */

public interface MenuDataProvider {
    Observable<List<Menu>> getAllItems();
}
