package com.pyn.jetpackpractice.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyn.jetpackpractice.R
import com.pyn.jetpackpractice.databinding.ActivityNavBinding

class NavActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityNavBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}