package com.example.buoi06

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class PhuongTrinhActivity : AppCompatActivity() {

    private var soA: EditText? = null
    private  var soB: EditText? = null
    private var soC: EditText? = null
    private  var btnTinh: Button? = null

    private var numberA = ""
    private var numberB = ""
    private var numberC = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_phuong_trinh)
         soA = findViewById(R.id.edt_soA)
         soB = findViewById(R.id.edt_soB)
         soC = findViewById(R.id.edt_soC)
         btnTinh = findViewById(R.id.btn_tinh)
         btnTinh?.isEnabled = false

        soA?.addTextChangedListener {
            numberA = it.toString()
            btnTinh?.isEnabled = numberA.isNotEmpty() && numberB.isNotEmpty() && numberC.isNotEmpty()
        }

        soB?.addTextChangedListener {
            numberB = it.toString()
            btnTinh?.isEnabled = numberA.isNotEmpty() && numberB.isNotEmpty() && numberC.isNotEmpty()
        }

        soC?.addTextChangedListener {
            numberC = it.toString()
            btnTinh?.isEnabled = numberA.isNotEmpty() && numberB.isNotEmpty() && numberC.isNotEmpty()
        }


        //cách khởi tạo interface TextWatcher
//        soA?.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        })
        btnTinh?.setOnClickListener{
            val a = soA?.text.toString().toDoubleOrNull() //do giá trị mặc định là null để ? thì giá trị của A có thể null
            val b = soB?.text.toString().toDoubleOrNull()
            val c = soC?.text.toString().toDoubleOrNull()
            //b?: khi b = null thì để giá trị mặc định
            timNghiemPhuongTrinhBacHai(a?: 0.0, b?: 0.0, c?:0.0)

        }

    }

    //giá trị a, b, c truyền vào không đc bị null
    private fun timNghiemPhuongTrinhBacHai(a: Double, b: Double, c: Double) {
        val delta = b.times(b) - 4.0 * a * c
        if (delta < 0) {
            Toast.makeText(this, "Phương trình vô nghiệm", Toast.LENGTH_LONG).show()
        }
        else if (delta == 0.0){
            Toast.makeText(this,
                "Phương trình có nghiệm kép x = " + -b / (2 * a),
                Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "Phương trình có 2 nghiệm" + "\n" +
                "x1 = " + (-b + sqrt(delta) / (2 * a)) + "\n" +
                    "x2 = " + (-b - sqrt(delta) / (2 * a))

                , Toast.LENGTH_LONG).show()
        }

    }
}