package com.pyn.jetpackpractice.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

/**
 * @author pengyanni
 * @date 2020/9/23  17:52.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class StudentViewModel(application: Application) : AndroidViewModel(application) {

    private lateinit var myDatabase: MyDatabase
    private lateinit var liveDataStudent: LiveData<List<Student>>

    init {
        myDatabase = MyDatabase.getInstance(application)
        liveDataStudent = myDatabase.studentDao().getStudentList()
    }

    fun getLiveDataStudent(): LiveData<List<Student>> {
        return liveDataStudent
    }

}