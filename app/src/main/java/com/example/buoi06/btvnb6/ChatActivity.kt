package com.example.buoi06.btvnb6

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R

class ChatActivity : AppCompatActivity() {
    lateinit var rcvData: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)
        rcvData = findViewById(R.id.rcvData)
        val adapter = ChatAdapter(addData(), this)
        rcvData.adapter = adapter
        rcvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter.onClickItem = {
            Toast.makeText(this, it.getData(), Toast.LENGTH_SHORT).show()
        }

    }

    fun addData(): List<Chat> {
        val chatList: MutableList<Chat> = ArrayList()
        val  chatItem = Chat().apply{
            this.image = R.drawable.ic_chat1
            this.title = "James"
            this.content = "Thank you! That was very helpful!"
        }
        val  chatItem1 = Chat().apply{
            this.image = R.drawable.ic_chat2
            this.title = "Will Kenny"
            this.content = "I know... I’m trying to get the funds."
        }
        val  chatItem2 = Chat().apply{
            this.image = R.drawable.ic_chat3
            this.title = "Beth Williams"
            this.content = "I’m looking for tips around capturing the milky way. I have a 6D with a 24-100mm..."
        }
        val  chatItem3 = Chat().apply{
            this.image = R.drawable.ic_chat4
            this.title = "Rev Shawn"
            this.content = "Wanted to ask if you’re available for a portrait shoot next week."
        }

        chatList.add(chatItem)
        chatList.add(chatItem1)
        chatList.add(chatItem2)
        chatList.add(chatItem3)
        return chatList
    }
}