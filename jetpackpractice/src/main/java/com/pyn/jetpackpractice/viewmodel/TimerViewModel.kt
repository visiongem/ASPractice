package com.pyn.jetpackpractice.viewmodel

import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.concurrent.timerTask

/**
 * @author pengyanni
 * @date 2020/9/22  16:09.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class TimerViewModel : ViewModel() {

    lateinit var timer: Timer
    var currentSecond: Int = 0

    private lateinit var onTimeChangeListener: OnTimeChangeListener

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }

    /**
     * 开始计时
     */
    fun startTiming() {

        timer = Timer()
        val timerTask = timerTask{
            currentSecond++
            onTimeChangeListener.onTimeChanged(currentSecond)
        }
        timer.schedule(timerTask, 1000, 1000)

    }

    interface OnTimeChangeListener {
        fun onTimeChanged(second: Int)
    }

    fun setOnTimeChangeListener(timeChangeListener: OnTimeChangeListener){
        this.onTimeChangeListener = timeChangeListener
    }
}