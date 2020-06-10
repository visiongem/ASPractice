package com.pyn.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyn.login.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
    }
}
