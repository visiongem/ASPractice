package com.pyn.jetpackpractice.lifecycle

import android.app.Activity
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author pengyanni
 * @date 2020/9/18  16:36.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class MyLocationListener(context: Activity, onLocationChangeListener: OnLocationChangeListener) : LifecycleObserver {

    init {
        // 初始化操作
        initLocationManager()
    }

    /**
     * 当Activity执行onResume()方法时，该方法被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun startGetLocation() {
        Log.d("MyLocationListener", "startGetLocation")
    }

    /**
     * 当Activity执行onPause()方法时，该方法被调用
     */
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun stopGetLocation() {
        Log.d("MyLocationListener", "stopGetLocation")
    }

    private fun initLocationManager() {

    }

    /**
     * 当地理位置发生变化时，通过该接口通知调用者
     */
    interface OnLocationChangeListener {
        fun onChanged(latitude: Double, longitude: Double)
    }

}