package com.pyn.jetpackpractice.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.pyn.jetpackpractice.R

class RecyclerviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recyclerview)

        val binding: ActivityRecyclerviewBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_recyclerview)

        binding.recyclerview.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerview.layoutManager = layoutManager

        val adapter = RecyclerViewAdapter(RecyclerViewViewModel().getBooks())

        binding.recyclerview.adapter = adapter

    }
}