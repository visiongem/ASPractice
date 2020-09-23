package com.pyn.jetpackpractice.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.timerTask

/**
 * @author pengyanni
 * @date 2020/9/22  17:51.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class TimerWithLiveDataViewModel : ViewModel() {

    lateinit var timer: Timer
    lateinit var currentSecond: MutableLiveData<Int>

    fun getCurrentSecond(): LiveData<Int> {
        currentSecond = MutableLiveData()
        return currentSecond
    }

    fun startTiming() {
        timer = Timer()
        val timerTask = timerTask {
            currentSecond.postValue(currentSecond.value?.plus(1))
        }
        timer.schedule(timerTask, 1000, 1000)
    }

}