package com.pyn.jetpackpractice.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.pyn.jetpackpractice.databinding.ActivityTimerBinding

class TimerActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initComponent()
    }

    private fun initComponent() {
        val timerViewModel = ViewModelProvider(this).get(TimerViewModel().javaClass)
        timerViewModel.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener{
            override fun onTimeChanged(second: Int) {
                runOnUiThread {
                    mBinding.tvTimer.text = "TIME : $second"
                }
            }
        })
        timerViewModel.startTiming()
    }
}