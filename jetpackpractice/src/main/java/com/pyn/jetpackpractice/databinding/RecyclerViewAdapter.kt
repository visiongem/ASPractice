package com.pyn.jetpackpractice.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pyn.jetpackpractice.R

class RecyclerViewAdapter(bookss: List<Book>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var books: List<Book> = bookss

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutItemBinding: ItemRecyclerviewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context)
            , R.layout.item_recyclerview
            , parent
            , false
        )
        return MyViewHolder(layoutItemBinding)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val book = books[position]
        holder.layoutItemBinding.book = book
    }

    class MyViewHolder(view: ItemRecyclerviewBinding) : RecyclerView.ViewHolder(view.root){

        val layoutItemBinding:ItemRecyclerviewBinding = view

    }
}