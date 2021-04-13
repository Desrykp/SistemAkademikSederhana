package com.client.loginmultiuserapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.client.loginmultiuserapp.R
import kotlinx.android.synthetic.main.card_layout.view.*

class RecyclerAdapter (materiList: MutableList<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var materi:MutableList<String> = materiList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return materi.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.judulMateri.text = materi[position]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        lateinit var gambarMateri: ImageView
        lateinit var judulMateri: TextView

        init {
            gambarMateri = itemView.findViewById(R.id.gambarMateri)
            judulMateri = itemView.findViewById(R.id.judulMateri)

            itemView.setOnClickListener {
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You Click On ${materi[position]}", Toast.LENGTH_LONG)
            }
        }
    }
}