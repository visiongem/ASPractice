package com.pyn.jetpackpractice.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author pengyanni
 * @date 2020/9/22  17:51.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class TimerWithLiveDataViewModel : ViewModel() {

    lateinit var currentSecond: MutableLiveData<Int>

    fun getCurrentSecond():LiveData<Int>{
        currentSecond = MutableLiveData()
        return currentSecond
    }

}