package com.makeomatic.sllibrary.presentation.main;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by OLEG on 10.11.2018.
 */

public interface MainRouter {
    void addFragment(Fragment fragment, Bundle arguments, boolean clearStack);
    void removeFragment(Fragment fragment);
}
