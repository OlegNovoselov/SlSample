package com.makeomatic.sllibrary.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.makeomatic.sllibrary.R;

/**
 * Created by OLEG on 09.11.2018.
 */

public class Metrics {
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static int convertDpToPixel(Context context, float dp){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

    /**
     * This method converts device specific pixels to density independent pixels.
     *
     * @param px A value in px (pixels) unit. Which we need to convert into db
     * @param context Context to get resources and device specific display metrics
     * @return A float value to represent dp equivalent to px value
     */
    public static float convertPixelsToDp(Context context, float px){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / (metrics.densityDpi / 160f);
        return dp;
    }

    public static int getWidthScreen(Activity activity) {
        DisplayMetrics dimension = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dimension);
        return dimension.widthPixels;
    }

    public static int getToolBarHeight(Context context) {
        TypedValue tv = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true);
        return context.getResources().getDimensionPixelSize(tv.resourceId);
//        int[] attrs = new int[] {R.attr.actionBarSize};
//        TypedArray ta = context.obtainStyledAttributes(attrs);
//        int toolBarHeight = ta.getDimensionPixelSize(0, -1);
//        ta.recycle();
//        return toolBarHeight * 2;
    }
}
