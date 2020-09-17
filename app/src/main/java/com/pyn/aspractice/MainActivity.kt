package com.pyn.aspractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pyn.aspractice.databinding.ActivityMainBinding
import java.lang.StringBuilder
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnDatePicker.setOnClickListener { this.startActivity(Intent(this, DatePickerActivity().javaClass)) }
        mBinding.btnTimePicker.setOnClickListener { this.startActivity(Intent(this, TimePickerActivity::class.java)) }
        mBinding.btnNotification.setOnClickListener { this.startActivity(Intent(this, NotificationActivity().javaClass)) }
        mBinding.btnClickRunnable.setOnClickListener { this.startActivity(Intent(this, ClickRunnableActivity().javaClass)) }

    }
}
