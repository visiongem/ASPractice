package com.pyn.jetpackpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyn.jetpackpractice.MyLocationListener.OnLocationChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLocationListener = MyLocationListener(this, object : OnLocationChangeListener {
            override fun onChanged(latitude: Double, longitude: Double) {
                // 展示收到的位置信息
            }
        })

        // 将观察者与被观察者绑定
        lifecycle.addObserver(myLocationListener)
    }
}
