package com.example.buoi06.btvnb6

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.buoi06.R


class ChatAdapter(val chatList: List<Chat>, val context: Context): RecyclerView.Adapter<ChatAdapter.ChatVH>(){

    class ChatVH(itemview: View): RecyclerView.ViewHolder(itemview){
        val ivAvatar: ImageView = itemview.findViewById(R.id.ivAvatar)
        val tvName: TextView = itemview.findViewById(R.id.tvName)
        val tvContent: TextView = itemview.findViewById(R.id.tvContent)

        fun setData(chat: Chat, context: Context) {
            tvName.text = chat.title
            tvContent.text = chat.content
            ivAvatar.setImageDrawable(chat.image?.let(context::getDrawable))

        }


    }

    var onClickItem: ((Chat) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatVH {
        //tạo ra item (view holder là 1 view giữ data)
        //tạo 1 cái viewholder bằng cách ìnflate
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat, parent, false) //chuyển file xml sang view
        return ChatVH(view)
    }

    override fun getItemCount(): Int = if (chatList.isNotEmpty()) chatList.size else 0

    override fun onBindViewHolder(holder: ChatVH, position: Int) {
        //set các dữ liệu cần thiết cho viewholder
        val currentItem = chatList[position]
        holder.setData(currentItem, context)
        holder.itemView.setOnClickListener {
            onClickItem?.invoke(chatList[position])
            //invoke để kích hoạt lamdafunction kiểm tra xem hàm onClickItem có null không
            //sau đấy gán tham số vị trí chatLisst cho nó
        }

    }

}