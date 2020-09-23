package com.pyn.jetpackpractice.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author pengyanni
 * @date 2020/9/23  13:37.
 * QQ: 393507488
 * Copyright (c) https://www.firstcapital.com.cn/ All rights reserved.
 */
class ShareDataViewModel : ViewModel() {

    var progress: MutableLiveData<Int>? = null

    fun getProgress(): LiveData<Int> {

        if (progress == null) {
            progress = MutableLiveData()
        }
        return progress as MutableLiveData<Int>
    }

    override fun onCleared() {
        super.onCleared()
        progress = null
    }
}