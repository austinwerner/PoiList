package com.example.poilist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_listitem.view.*

class RecyclerViewAdapter: RecyclerView.Adapter<CustomViewHolder>() {

    val addresses = listOf<String>( "123 Ass street", "Your mom's house", "Your other mom's house")

    override fun getItemCount(): Int {
        return addresses.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.layout_listitem, parent, false)
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val address = addresses.get(position)
        holder.view.address.text = address
    }
}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}