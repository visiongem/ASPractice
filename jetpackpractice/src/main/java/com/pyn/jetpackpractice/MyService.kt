package com.pyn.jetpackpractice

import androidx.lifecycle.LifecycleService

/**
 * @author pengyanni
 * @date 2020/9/21  14:40.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class MyService : LifecycleService() {

    private var myServiceObserver : MyServiceObserver = MyServiceObserver()

    init {
        // 将观察者与被观察者绑定
        lifecycle.addObserver(myServiceObserver)
    }

}