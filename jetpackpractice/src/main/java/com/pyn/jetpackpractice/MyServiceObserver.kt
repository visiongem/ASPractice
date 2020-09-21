package com.pyn.jetpackpractice

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author pengyanni
 * @date 2020/9/21  14:42.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class MyServiceObserver : LifecycleObserver{

    /**
     * 当Service执行onCreate()方法时，该方法被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun startGetLocation(){
        Log.d("MyServiceObserver", "startGetLocation()")
    }

    /**
     * 当Service执行onDestroy()方法时，该方法被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private fun stopGetLocation() {
        Log.d("MyServiceObserver", "stopGetLocation")
    }

}