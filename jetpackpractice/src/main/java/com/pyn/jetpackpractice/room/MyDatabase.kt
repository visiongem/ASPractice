package com.pyn.jetpackpractice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * @author pengyanni
 * @date 2020/9/23  16:43.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
@Database(entities = arrayOf(Student::class), version = 1)
abstract class MyDatabase() : RoomDatabase() {

    companion object {
        val DATAVASE_NAME = "my_db"
        private lateinit var databaseInstance: MyDatabase

        fun getInstance(context: Context): MyDatabase {
            databaseInstance = Room.databaseBuilder(context.applicationContext, MyDatabase::class.java, DATAVASE_NAME).build()
            return databaseInstance
        }
    }

    abstract fun studentDao(): StudentDao
}