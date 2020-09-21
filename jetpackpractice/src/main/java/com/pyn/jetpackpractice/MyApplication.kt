package com.pyn.jetpackpractice

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.pyn.jetpackpractice.lifecycle.ApplicationObserver

/**
 * @author pengyanni
 * @date 2020/9/21  15:12.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        // ProcessLifecycleOwner是针对整个应用程序的监听
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}