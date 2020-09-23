package com.pyn.jetpackpractice.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pyn.jetpackpractice.databinding.ActivityTimerBinding
import com.pyn.jetpackpractice.livedata.TimerWithLiveDataViewModel

class TimerActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityTimerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityTimerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initComponent()
    }

    private fun initComponent() {
        // 没有 livedata
        /* val timerViewModel = ViewModelProvider(this).get(TimerViewModel().javaClass)
         timerViewModel.setOnTimeChangeListener(object : TimerViewModel.OnTimeChangeListener{
             override fun onTimeChanged(second: Int) {
                 runOnUiThread {
                     mBinding.tvTimer.text = "TIME : $second"
                 }
             }
         })
         timerViewModel.startTiming()*/

        val timerViewModel = ViewModelProvider(this).get(TimerWithLiveDataViewModel().javaClass)
        val liveData: MutableLiveData<Int> = timerViewModel.getCurrentSecond() as MutableLiveData<Int>

        liveData.observe(this, Observer { mBinding.tvTimer.text = "TIME:$it" })

        mBinding.btnResetTime.setOnClickListener {
            liveData.value = 0
            timerViewModel.startTiming()
        }
    }
}