package com.pyn.jetpackpractice

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author pengyanni
 * @date 2020/9/21  15:13.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class ApplicationObserver : LifecycleObserver {

    /**
     * 在应用程序的整个生命周期中只会被调用一次
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d("ApplicationObserver", "Lifecycle.Event.ON_CREATE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.d("ApplicationObserver", "Lifecycle.Event.ON_START")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.d("ApplicationObserver", "Lifecycle.Event.ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.d("ApplicationObserver", "Lifecycle.Event.ON_PAUSE")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.d("ApplicationObserver", "Lifecycle.Event.ON_STOP")
    }

    /**
     * 永远不会被调用，系统不会分发调用ON_DESTROY事件
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d("ApplicationObserver", "Lifecycle.Event.ON_DESTROY")
    }
}