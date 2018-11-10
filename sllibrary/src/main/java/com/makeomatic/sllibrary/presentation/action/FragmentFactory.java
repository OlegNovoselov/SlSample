package com.makeomatic.sllibrary.presentation.action;


import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.presentation.common.BaseFragment;

/**
 * Created by OLEG on 10.11.2018.
 */

public class FragmentFactory {
    public static BaseFragment instance(Menu menu) {
        return new Action1Fragment();
    }
}
