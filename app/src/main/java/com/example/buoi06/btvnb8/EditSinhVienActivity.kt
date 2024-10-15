package com.example.buoi06.btvnb8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R
import kotlin.math.sinh

class EditSinhVienActivity : AppCompatActivity() {
    private var edtName: EditText? = null
    private var edtAddress: EditText? = null
    private var edtPhone: EditText? = null
    private var btnSave: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_sinh_vien)

        edtName = findViewById(R.id.edtName)
        edtAddress = findViewById(R.id.edtAdress)
        edtPhone = findViewById(R.id.edtPhone)
        btnSave = findViewById(R.id.btnSave)

        //nhận dữ liệu truyền sang
        val sinhvien = intent.extras?.get("sinhvien") as SinhVien
        if (sinhvien != null){
            edtName?.setText(sinhvien.name)
            edtAddress?.setText(sinhvien.addRess)
            edtPhone?.setText(sinhvien.phone)
        }

//        btnSave?.setOnClickListener {
//            if (sinhvien != null){
//                sendData(sinhvien)
//            }
//        }

    }

//    fun sendData(sinhVien: SinhVien) {
//        sinhVien?.name = edtName?.text.toString() ?:""
//        sinhVien?.addRess = edtAddress?.text.toString() ?:""
//        sinhVien?.phone = edtPhone?.text.toString() ?:""
//        val intent = Intent()
//        intent.putExtra("sinhvien", sinhVien)
//        intent.putExtra(SinhVienActivity.KEY, SinhVienActivity.TYPE_EDIT)
//        setResult(Activity.RESULT_OK, intent)
//        finish()
//
//    }
}