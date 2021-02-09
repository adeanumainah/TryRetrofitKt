package com.dean.tryretrofitkt.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dean.tryretrofitkt.R
import com.dean.tryretrofitkt.model.ResponseUsers
import kotlinx.android.synthetic.main.item_users.view.*
import kotlinx.android.synthetic.main.item_users.view.*

class UsersAdapter(val data: List<ResponseUsers>?) : RecyclerView.Adapter<UsersAdapter.MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        return MyHolder(v)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(data?.get(position))
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(get: ResponseUsers?) {
            itemView.nama.text = get?.name
            itemView.email.text = get?.email
            itemView.phone.text = get?.phone

            val address = "${get?.address?.street}, ${get?.address?.city}, ${get?.address?.suite}, ${get?.address?.zipcode}"
            itemView.alamat.text = address
        }

    }

}