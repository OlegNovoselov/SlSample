package com.makeomatic.sllibrary.presentation.action;

import com.makeomatic.sllibrary.domain.demo.DemoItem;
import com.makeomatic.sllibrary.presentation.common.BaseView;

import java.util.List;

/**
 * Created by OLEG on 10.11.2018.
 */

public interface DemoView extends BaseView {
    public void setItems(List<DemoItem> items);

}

