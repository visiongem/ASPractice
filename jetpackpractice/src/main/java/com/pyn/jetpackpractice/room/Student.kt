package com.pyn.jetpackpractice.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author pengyanni
 * @date 2020/9/23  16:17.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER) var id: Int,
    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT) var name: String,
    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER) var age: Int
)