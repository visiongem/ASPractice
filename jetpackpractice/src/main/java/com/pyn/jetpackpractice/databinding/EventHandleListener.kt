package com.pyn.jetpackpractice.databinding

import android.content.Context
import android.view.View
import android.widget.Toast

class EventHandleListener(val mContext: Context) {

    fun onBtnClick(view: View) {
        Toast.makeText(mContext, "clicked", Toast.LENGTH_SHORT).show()
    }

}