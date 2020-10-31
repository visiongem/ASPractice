package com.pyn.jetpackpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pyn.jetpackpractice.lifecycle.MyLocationListener.OnLocationChangeListener
import com.pyn.jetpackpractice.databinding.ActivityMainBinding
import com.pyn.jetpackpractice.databinding.DatabindingActivity
import com.pyn.jetpackpractice.lifecycle.MyLocationListener
import com.pyn.jetpackpractice.lifecycle.MyService
import com.pyn.jetpackpractice.navigation.NavActivity
import com.pyn.jetpackpractice.room.RoomActivity
import com.pyn.jetpackpractice.viewmodel.TimerActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myLocationListener: MyLocationListener
    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        myLocationListener = MyLocationListener(this, object : OnLocationChangeListener {
            override fun onChanged(latitude: Double, longitude: Double) {
                // 展示收到的位置信息
            }
        })

        // 将观察者与被观察者绑定
        lifecycle.addObserver(myLocationListener)

        mBinding.btnStartService.setOnClickListener {
            // 启动服务
            val intent = Intent(this, MyService().javaClass)
            startService(intent)
        }

        mBinding.btnStopService.setOnClickListener {
            // 停止服务
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }

        mBinding.btnToNavigation.setOnClickListener {
            val intent = Intent(this, NavActivity().javaClass)
            startActivity(intent)
        }

        mBinding.btnToTimer.setOnClickListener {
            val intent = Intent(this, TimerActivity().javaClass)
            startActivity(intent)
        }

        mBinding.btnRoom.setOnClickListener {
            val intent = Intent(this, RoomActivity().javaClass)
            startActivity(intent)
        }

        mBinding.btnDatabinding.setOnClickListener {
            val intent = Intent(this, DatabindingActivity().javaClass)
            startActivity(intent)
        }

    }
}
