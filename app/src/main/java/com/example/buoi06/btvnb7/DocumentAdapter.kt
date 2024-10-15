package com.example.buoi06.btvnb7

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R

class DocumentAdapter(val documentList: ArrayList<Document>, val context: Context): RecyclerView.Adapter<DocumentAdapter.DocumentVH>() {

    class DocumentVH(itemview: View): RecyclerView.ViewHolder(itemview){
        val ivDocument = itemview.findViewById<ImageView>(R.id.ivDocument)
        val tvTitle = itemview.findViewById<TextView>(R.id.tvTitle)
        val tvContent = itemview.findViewById<TextView>(R.id.tvContent)

        fun setData(document: Document, context: Context) {
            tvTitle.text = document.title
            tvContent.text = document.content
//            ivDocument.setImageDrawable(document.image.let (context::getDrawable))
        }
    }

    //lấy đối tượng và vị trí khi click vào item
    var onClickItem: ((Document, Int /*Int là vị trí của document*/) -> Unit)? = null
    var onClickItem2: ((Document) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DocumentVH {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_document, parent, false)
        return DocumentVH(view)
    }

    override fun getItemCount(): Int = if (documentList.isNotEmpty()) documentList.size else 0

    override fun onBindViewHolder(holder: DocumentVH, position: Int) {
        val currentItem = documentList[position]
        holder.setData(currentItem, context)

        holder.itemView.setOnClickListener {
            onClickItem?.invoke(currentItem, position)
        }
    }


}