package com.pyn.jetpackpractice.room

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * @author pengyanni
 * @date 2020/9/23  16:27.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
@Dao
interface StudentDao {

    @Insert
    fun insertStudent(student: Student)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun updateStudent(student: Student)

    @Query("SELECT * FROM student")
    fun getStudentList(): LiveData<List<Student>>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int)
}