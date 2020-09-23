package com.pyn.jetpackpractice.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pyn.jetpackpractice.databinding.ActivityMainBinding
import com.pyn.jetpackpractice.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityRoomBinding
    private lateinit var studentList:List<Student>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val studentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        studentViewModel.getLiveDataStudent().observe(this, Observer {
//            studentList.clear()
//            studentList.addAll(it)
        })
    }
}