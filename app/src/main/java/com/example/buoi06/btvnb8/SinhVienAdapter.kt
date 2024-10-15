package com.example.buoi06.btvnb8

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R
import com.example.buoi06.btvnb7.Document


class SinhVienAdapter(var sinhVienList: ArrayList<SinhVien>, val context: Context): RecyclerView.Adapter<SinhVienAdapter.SinhVienVH>() {

    class SinhVienVH(itemView: View):RecyclerView.ViewHolder(itemView){
       val tvName = itemView.findViewById<TextView>(R.id.tvName)
       val tvAddress = itemView.findViewById<TextView>(R.id.tvAddress)
       val tvPhone = itemView.findViewById<TextView>(R.id.tvPhone)
       val btnDelete = itemView.findViewById<ImageButton>(R.id.ivBin)
        fun setData(sinhVien: SinhVien, context: Context){
            tvName.text = sinhVien.name
            tvAddress.text = sinhVien.addRess
            tvPhone.text = sinhVien.phone
        }
    }

    fun setArrayList(sinhVienList: ArrayList<SinhVien>) {
        this.sinhVienList = sinhVienList
    }

    var onClickItem: ((SinhVien, Int) -> Unit)? = null
    var onRemoveItem: ((Int) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SinhVienVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sinhvien, parent, false)
        return SinhVienVH(view)
    }

    override fun getItemCount(): Int = if (sinhVienList.isNotEmpty()) sinhVienList.size else 0

    override fun onBindViewHolder(holder: SinhVienVH, position: Int) {
        val currentItem = sinhVienList[position]
        holder.setData(currentItem, context)

        holder.itemView.setOnClickListener {
            onClickItem?.invoke(currentItem, position)
        }

        holder.btnDelete.setOnClickListener {
            onRemoveItem?.invoke(position)
        }

    }
}