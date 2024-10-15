package com.example.buoi06.buoi8

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R

class Buoi8Activity : AppCompatActivity() {
    //một số database hay dùng: SQlite(không ai dùng nữa), Realm(tối ưu nhất dùng đc cả apk và ios), Room()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi8)

        val edtName = findViewById<EditText>(R.id.edtName)
        val tvName = findViewById<TextView>(R.id.tvName)
        val btnSave = findViewById<Button>(R.id.btnSave)
         //lấy dữ liệu name được lưu ở local và set vào text view
        tvName.text = SharePreferentUltils.getName(this)

        btnSave.setOnSingleClick {
//            val name = edtName.text.toString().trim()
//            SharePreferentUltils.saveName(name, this)
//            tvName.text = SharePreferentUltils.getName(this)
            //lệnh lấy ra DAO

        }


    }
}