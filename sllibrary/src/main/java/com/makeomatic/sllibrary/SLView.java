package com.makeomatic.sllibrary;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.makeomatic.sllibrary.domain.menu.Menu;
import com.makeomatic.sllibrary.presentation.action.FragmentFactory;
import com.makeomatic.sllibrary.presentation.common.BaseFragment;
import com.makeomatic.sllibrary.presentation.di.DaggerMainActivityComponent;
import com.makeomatic.sllibrary.presentation.di.DataModule;
import com.makeomatic.sllibrary.presentation.di.DomainModule;
import com.makeomatic.sllibrary.presentation.di.MainActivityComponent;
import com.makeomatic.sllibrary.presentation.main.MainPresenter;
import com.makeomatic.sllibrary.presentation.main.MainRouter;
import com.makeomatic.sllibrary.presentation.main.MainView;
import com.makeomatic.sllibrary.presentation.menu.MenuAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OLEG on 09.11.2018.
 */

public class SLView extends FrameLayout implements MainView, MainRouter {
    private static MainActivityComponent mainActivityComponent;
    private RecyclerView recyclerViewMenu;
    private View viewButton;
    private Animation animation;
    private FrameLayout frameLayout;
    private List<Fragment> fragmentStack = new ArrayList<>();

    private boolean stateButton = false;

    public SLView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
    }

    public SLView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public SLView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        View view = inflate(getContext(), R.layout.main_layout, null);
        addView(view);
        recyclerViewMenu = view.findViewById(R.id.recyclerViewMenu);
        recyclerViewMenu.setVisibility(GONE);
        viewButton = findViewById(R.id.imageViewButton);
        viewButton.setVisibility(GONE);
        animation = AnimationUtils.loadAnimation(getContext(), R.anim.myscale);
        frameLayout = findViewById(R.id.frameLayout);

        viewButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                stateButton = !stateButton;
                if(stateButton)
                    ((ImageView) findViewById(R.id.imageViewButton)).setImageResource(R.drawable.btn2);
                else
                    ((ImageView) findViewById(R.id.imageViewButton)).setImageResource(R.drawable.btn1);

                onChangeMainState();
            }
        });
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MainPresenter mainPresenter = getMainComponent().mainPresenter();
        mainPresenter.setView(this);
        mainPresenter.onStart();
    }

    public static MainActivityComponent getMainComponent() {
        if(mainActivityComponent == null) {
            mainActivityComponent =
                    DaggerMainActivityComponent
                            .builder()
                            .dataModule(new DataModule())
                            .domainModule(new DomainModule())
                            .build();
        }

        return mainActivityComponent;
    }

    @Override
    public void setMenu(List<Menu> items) {
        viewButton.setVisibility(VISIBLE);
        recyclerViewMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        MenuAdapter adapter = new MenuAdapter(getContext(), items);
        adapter.setOnItemClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getTag() != null && view.getTag() instanceof Menu) {
                    selectedMenuItem((Menu) view.getTag());
                }
            }
        });
        recyclerViewMenu.setAdapter(adapter);
    }

    private void selectedMenuItem(Menu item) {
        BaseFragment fragment = FragmentFactory.instance(item);
        fragment.setRouter(this);
        addFragment(fragment, null, true);
        hideMenu();
    }

    private void onChangeMainState() {
        if(stateButton) {
            showMenu();
        } else {
            hideMenu();
            removeAllFragments();
        }
    }

    private void showMenu(){
        recyclerViewMenu.setVisibility(View.VISIBLE);
        recyclerViewMenu.startAnimation(animation);
    }

    private void hideMenu(){
        recyclerViewMenu.setVisibility(View.GONE);
    }

    private void removeAllFragments(FragmentTransaction fragmentTransaction) {
        for (Fragment fragment : fragmentStack) {
            fragmentTransaction.remove(fragment);
        }

        fragmentStack.clear();
    }

    private void removeAllFragments() {
        FragmentManager fragmentManager = ((Activity) getContext()).getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        removeAllFragments(fragmentTransaction);
        fragmentTransaction.commit();
    }

    @Override
    public void showError(@StringRes int message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addFragment(Fragment fragment, Bundle arguments, boolean clearStack) {
        FragmentManager fragmentManager = ((Activity) getContext()).getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(clearStack)
            removeAllFragments(fragmentTransaction);

        if(arguments != null)
            fragment.setArguments(arguments);

        fragmentTransaction.add(R.id.frameLayout, fragment);
        fragmentStack.add(fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void removeFragment(Fragment fragment) {
        FragmentManager fragmentManager = ((Activity) getContext()).getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }
}
