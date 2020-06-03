package com.pyn.mortgage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyn.mortgage.databinding.ActivityMortgageBinding

class MortgageActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMortgageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMortgageBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}
