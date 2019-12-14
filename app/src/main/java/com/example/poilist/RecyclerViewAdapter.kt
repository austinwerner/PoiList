package com.example.poilist

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_listitem.view.*

class RecyclerViewAdapter(val allStores: AllStores): RecyclerView.Adapter<CustomViewHolder>() {

    private var context: Context? = null

    override fun getItemCount(): Int {
        return allStores.stores.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.layout_listitem, parent, false)

        context = parent.getContext()
        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val stores = allStores.stores[position]
        holder.view.name.text = stores.name
        holder.view.city.text = stores.city + ", " + stores.state
        holder.view.number.text = stores.phone

        val thumbnail = holder.view.image
        Picasso.get().load(stores.storeLogoURL).into(thumbnail)

        holder.view.image.setOnClickListener{
            val intent = Intent(context, StoreInfo::class.java)

            //intent.putExtra("keyIdentifier", value)
            context?.startActivity(intent)
        }
    }


}

class CustomViewHolder(val view: View): RecyclerView.ViewHolder(view) {

}
