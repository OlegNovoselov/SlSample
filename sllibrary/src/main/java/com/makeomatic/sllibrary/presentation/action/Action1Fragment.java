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
import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.presentation.common.BaseFragment;
import com.makeomatic.sllibrary.presentation.common.BasePresenter;
import com.makeomatic.sllibrary.presentation.main.MainView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by OLEG on 10.11.2018.
 */

public class Action1Fragment extends BaseFragment implements DemoView {
    @Inject
    Action1Presenter presenter;

    private int current = 0;
    private List<DemoItem> items;

    @Override
    protected int getLayoutView() {
        return R.layout.action1_layout;
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
        this.items = items;
        init();
        show();
    }

    private void init() {
        getRootView().findViewById(R.id.buttonBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current == 0)
                    current = items.size() - 1;
                else
                    current--;

                show();
            }
        });

        getRootView().findViewById(R.id.buttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current >= items.size())
                    current = 0;
                else
                    current++;

                show();
            }
        });

        getRootView().findViewById(R.id.buttonSelect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRouter().addFragment(new Action2Fragment(), null, true);
            }
        });
    }

    private void show() {
        if(items.size() <= current)
            return;

        DemoItem item = items.get(current);
        ((TextView) getRootView().findViewById(R.id.textViewPoints)).setText(item.getPoints());
        ((TextView) getRootView().findViewById(R.id.textViewTitle)).setText(item.getTitle());

        Resources res =  getActivity().getResources();
        int resID = res.getIdentifier(item.getImage() , "drawable", getActivity().getPackageName());
        ((ImageView) getRootView().findViewById(R.id.imageView)).setImageResource(resID);
    }
}
