package com.pyn.tablayout.tablayout;

import androidx.annotation.DrawableRes;

public interface CustomTabEntity {

    String getTabTitle();

    @DrawableRes
    int getTabSelectedIcon();

    @DrawableRes
    int getTabUnselectedIcon();
}