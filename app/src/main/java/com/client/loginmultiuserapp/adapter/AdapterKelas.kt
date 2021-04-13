package com.client.loginmultiuserapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.client.loginmultiuserapp.R
import com.client.loginmultiuserapp.models.Kelas

class AdapterKelas (val kelasList: List<Kelas>) : RecyclerView.Adapter<AdapterKelas.KelasLS>(){

    class KelasLS(itemView: View) : RecyclerView.ViewHolder(itemView){

        val namakelasTxt : TextView = itemView.findViewById(R.id.namaKelas)
        val namamentorTxt : TextView = itemView.findViewById(R.id.namMentor)
        val jadwalkelasTxt : TextView = itemView.findViewById(R.id.jadwalKelas)
        val deskripsikelasTxt : TextView = itemView.findViewById(R.id.deskripsiKelas)
        val linearLayout : LinearLayout = itemView.findViewById(R.id.linearLayout)
        val expandableLayout : RelativeLayout = itemView.findViewById(R.id.explainable_Layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KelasLS {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_kelas, parent, false)

        return KelasLS(view)
    }

    override fun getItemCount(): Int {
        return kelasList.size
    }

    override fun onBindViewHolder(holder: KelasLS, position: Int) {
        val kelas : Kelas = kelasList[position]
        holder.namakelasTxt.text = kelas.nkelas
        holder.namamentorTxt.text = kelas.nMentor
        holder.jadwalkelasTxt.text = kelas.nJadwal
        holder.deskripsikelasTxt.text = kelas.nDeskripsi

        val isExpandable : Boolean = kelasList[position].explainable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.linearLayout.setOnClickListener{
            val kelas = kelasList[position]
            kelas.explainable =!kelas.explainable
            notifyItemChanged(position)
        }

    }
}