package com.example.buoi06.btvnb6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R

class DogAdapter(val dogList: List<Dog>, val context: Context): RecyclerView.Adapter<DogAdapter.DogVH>(){

    class DogVH(itemview: View):RecyclerView.ViewHolder(itemview){
        val ivDog = itemview.findViewById<ImageView>(R.id.ivDog)

        fun setData (dog: Dog, context: Context) {
            ivDog.setImageDrawable(dog.image?.let(context::getDrawable))
        }
    }

    var onClickItem: ((Dog) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogVH(view)
    }

    override fun getItemCount(): Int = if (dogList.isNotEmpty()) dogList.size else 0

    override fun onBindViewHolder(holder: DogVH, position: Int) {
       val currentItem = dogList[position]
        holder.setData(currentItem, context)
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(dogList[position])
        }
    }
}