package com.pyn.jetpackpractice.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.pyn.jetpackpractice.R

class DatabindingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var book = Book("title","author", 1)

        val binding: ActivityDatabindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_databinding)

        binding.book = book

        binding.eventHandler = EventHandleListener(this)


    }
}