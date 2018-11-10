package com.makeomatic.sllibrary.presentation.action;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.makeomatic.sllibrary.R;
import com.makeomatic.sllibrary.SLView;
import com.makeomatic.sllibrary.domain.demo.DemoItem;
import com.makeomatic.sllibrary.presentation.common.BaseFragment;
import com.makeomatic.sllibrary.presentation.common.BasePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by OLEG on 10.11.2018.
 */

public class Action2Fragment extends BaseFragment implements DemoView {
    @Inject
    Action1Presenter presenter;

    private int current = 0;
    private List<DemoItem> items;

    @Override
    protected int getLayoutView() {
        return R.layout.action2_layout;
    }

    @NonNull
    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void inject() {
        SLView.getMainComponent().inject(this);
    }


    @Override
    public void showError(int message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setItems(List<DemoItem> items) {

    }
}
