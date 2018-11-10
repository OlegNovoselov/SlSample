package com.makeomatic.sllibrary.domain.demo;

import com.makeomatic.sllibrary.domain.menu.Menu;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by OLEG on 10.11.2018.
 */

public interface DemoItemProvider {
    Observable<List<DemoItem>> getAllItems();
}
