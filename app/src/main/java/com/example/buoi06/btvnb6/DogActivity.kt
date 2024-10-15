package com.example.buoi06.btvnb6

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R

class DogActivity : AppCompatActivity() {
    lateinit var rcvData: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog)
        rcvData = findViewById(R.id.rcvData)
        val adapter = DogAdapter(addData(), this)
        rcvData.adapter = adapter
        // Tạo và cài đặt GridLayoutManager với spanCount là 3
        val layoutManager = GridLayoutManager(this, 3)
        rcvData.layoutManager = layoutManager


        adapter.onClickItem = {
            Toast.makeText(this, it.getData(), Toast.LENGTH_SHORT).show()
        }


    }

    fun addData(): List<Dog> {
        val dogList: MutableList<Dog> = ArrayList()

        val dogItem1 = Dog().apply{
            this.image = R.drawable.ic_dog1
        }

        val dogItem2 = Dog().apply{
            this.image = R.drawable.ic_dog2
        }
        val dogItem3 = Dog().apply{
            this.image = R.drawable.ic_dog3
        }
        val dogItem4 = Dog().apply{
            this.image = R.drawable.ic_dog4
        }
        val dogItem5 = Dog().apply{
            this.image = R.drawable.ic_dog5
        }
        val dogItem6 = Dog().apply{
            this.image = R.drawable.ic_dog6
        }
        val dogItem7 = Dog().apply{
            this.image = R.drawable.ic_dog7
        }
        val dogItem8 = Dog().apply{
            this.image = R.drawable.ic_dog8
        }
        val dogItem9 = Dog().apply{
            this.image = R.drawable.ic_dog9
        }
        val dogItem10 = Dog().apply{
            this.image = R.drawable.ic_dog10
        }
        val dogItem11 = Dog().apply{
            this.image = R.drawable.ic_dog11
        }
        val dogItem12 = Dog().apply{
            this.image = R.drawable.ic_dog12
        }
        dogList.add(dogItem1)
        dogList.add(dogItem2)
        dogList.add(dogItem3)
        dogList.add(dogItem4)
        dogList.add(dogItem5)
        dogList.add(dogItem6)
        dogList.add(dogItem7)
        dogList.add(dogItem8)
        dogList.add(dogItem9)
        dogList.add(dogItem10)
        dogList.add(dogItem11)
        dogList.add(dogItem12)
        return dogList
    }
}