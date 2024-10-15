package com.example.buoi06.btvnb8

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.buoi06.R

class AddSinhVienActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtAddress: EditText? = null
    private var edtPhone: EditText? = null
    private var btnSave: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_sinh_vien)
        edtName = findViewById(R.id.edtName)
        edtAddress = findViewById(R.id.edtAdress)
        edtPhone = findViewById(R.id.edtPhone)
        btnSave = findViewById(R.id.tvSave)


        btnSave?.setOnClickListener {
            val addName : String = edtName?.text.toString()
            val addAddress : String = edtAddress?.text.toString()
            val addPhone : String = edtPhone?.text.toString()
            val intent = Intent()
            intent.putExtra("name", addName)
            intent.putExtra("address", addAddress)
            intent.putExtra("phone", addPhone)
//            intent.putExtra(SinhVienActivity.KEY, SinhVienActivity.TYPE_ADD)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}