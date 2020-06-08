package com.pyn.aspractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pyn.aspractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.btnDatePicker.setOnClickListener { this.startActivity(Intent(this, DatePickerActivity().javaClass)) }
        mBinding.btnTimePicker.setOnClickListener { this.startActivity(Intent(this, TimePickerActivity::class.java)) }
        mBinding.btnNotification.setOnClickListener { this.startActivity(Intent(this, NotificationActivity().javaClass)) }

    }
}
