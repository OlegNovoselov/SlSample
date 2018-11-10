package com.makeomatic.sllibrary.presentation.main;

import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.presentation.common.BaseView;

import java.util.List;

/**
 * Created by OLEG on 10.11.2018.
 */

public interface MainView extends BaseView {
    public void setMenu(List<Menu> items);
}
