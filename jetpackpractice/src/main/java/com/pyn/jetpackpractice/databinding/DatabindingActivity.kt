package com.pyn.jetpackpractice.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.pyn.jetpackpractice.R
import kotlinx.android.synthetic.main.activity_main.*

class DatabindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityDatabindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var book = Book("title", "author", 1)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databinding)

        binding.book = book

        binding.eventHandler = EventHandleListener(this)

        binding.networkImage =
            "https://static01.imgkr.com/temp/a5f0ff2e7ab741ffa49504c097b56fac.jpg"

        binding.localImage = R.drawable.ic_launcher_background

        binding.clickHandler = ClickHandler()
        binding.imagePadding = 40

        binding.viewModel = TwoWayBindingViewModel()

    }

    inner class ClickHandler {

        fun onClick(view: View) {
            Log.d("ClickHandler","padding")
            binding.imagePadding = 100
        }
    }
}