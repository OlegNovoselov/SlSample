package com.makeomatic.sllibrary.data;

import com.makeomatic.sllibrary.domain.demo.DemoItem;
import com.makeomatic.sllibrary.domain.demo.DemoItemProvider;
import com.makeomatic.sllibrary.domain.menu.Menu;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by OLEG on 10.11.2018.
 */

public class DemoDataProviderImpl  implements DemoItemProvider {
    @Override
    public Observable<List<DemoItem>> getAllItems() {
        List<DemoItem> result = new ArrayList<>();

        result.add(new DemoItem("Field Goals", "logo1", "0.4"));
        result.add(new DemoItem("Passing Yards", "logo2", "48.5"));
        result.add(new DemoItem("Pushing Yards", "logo1", "30.2"));
        result.add(new DemoItem("Passing Yards", "logo2", "50.4"));
        result.add(new DemoItem("Field Goals", "logo1", "0.8"));

        return Observable.just(result);
    }
}
