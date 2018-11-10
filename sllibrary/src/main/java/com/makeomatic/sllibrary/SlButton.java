package com.makeomatic.sllibrary;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by OLEG on 09.11.2018.
 */

public class SlButton extends View implements View.OnClickListener {
    public enum Status{
        ON,
        OFF
    }

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Status status = Status.OFF;
    private View mainView;

    public SlButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(this);
        createMainView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(status == Status.ON)
            paint.setColor(Color.parseColor("#ff0000"));
        else
            paint.setColor(Color.parseColor("#ffff00"));
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, getWidth() / 2, paint);
    }

    @Override
    public void onClick(View view){
        if(status == Status.ON) {
            mainView.setVisibility(INVISIBLE);
            status = Status.OFF;
        } else {
            mainView.setVisibility(VISIBLE);
            status = Status.ON;
        }
        invalidate();
    }

    private void createMainView() {
        View rootView = ((Activity) getContext()).getWindow().getDecorView().getRootView();
        if(rootView != null) {
            if(rootView instanceof ViewGroup) {
                ViewGroup rootViewGroup = (ViewGroup) rootView;
                mainView = new SLView(getContext());
                mainView.setVisibility(GONE);
                rootViewGroup.addView(mainView);
            }
        }
    }
}
