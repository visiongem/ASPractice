package com.pyn.aspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pyn.aspractice.databinding.ActivityClickRunnableBinding
import com.pyn.aspractice.databinding.ActivityDatePickerBinding

class ClickRunnableActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityClickRunnableBinding
    private var isStarted = false
    private var mHandler = Handler()
    private var mCount = 0

    private var mCounter = object : Runnable {
        override fun run() {
            mCount++
            mBinding.tvCount.setText("当前计数值为：$mCount")
            mHandler.postDelayed(this, 1000)
        }
    }

//    inner private class Counter:Runnable{
//        override fun run() {
//            mCount++
//            mBinding.tvCount.setText("当前计数值为：$mCount")
//            mHandler.postDelayed(this, 1000)
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityClickRunnableBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnCount.setOnClickListener {
            if (!isStarted) {
                mBinding.btnCount.setText("停止计数")
                mHandler.post(mCounter)
            } else {
                mBinding.btnCount.setText("开始计数")
                mHandler.removeCallbacks(mCounter)
            }
            isStarted = !isStarted

        }
    }
}