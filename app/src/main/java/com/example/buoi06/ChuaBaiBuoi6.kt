package com.example.buoi06

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import java.text.SimpleDateFormat
import java.util.*

class ChuaBaiBuoi6 : AppCompatActivity() {
    private var edtFullname: EditText?  = null
    private var edtPhone: EditText?  = null
    private var tvDate: TextView?  = null
    private var btnUpdate: TextView?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chua_bai_buoi6)
        edtPhone = findViewById(R.id.edtPhone)
        edtFullname = findViewById(R.id.edtFullname)
        tvDate = findViewById(R.id.edtDate)
        btnUpdate = findViewById(R.id.btnUpdate)

        edtFullname?.addTextChangedListener {
            setEnableButton()
        }

        edtPhone?.addTextChangedListener {
            setEnableButton()
        }

       tvDate?.setOnClickListener {
           openChooseDate()
       }

        setEnableButton()
    }

    private fun openChooseDate() {
        val myCalendar = java.util.Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, dayofMonth ->
            myCalendar.set(java.util.Calendar.YEAR, year)
            myCalendar.set(java.util.Calendar.MONTH, month)
            myCalendar.set(java.util.Calendar.DAY_OF_MONTH, dayofMonth)
            updateLable(myCalendar)
        }
        DatePickerDialog(this, datePicker, myCalendar.get(java.util.Calendar.YEAR), myCalendar.get(
            java.util.Calendar.MONTH), myCalendar.get(java.util.Calendar.DAY_OF_MONTH)).show()
    }

    private fun updateLable(myCalendar: java.util.Calendar) {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale("vi", "VN"))
        tvDate?.text = sdf.format(myCalendar.time)
        setEnableButton()
    }

    private fun setEnableButton() {
        btnUpdate?.isEnabled = isEnableButtonUpdate()
        if (isEnableButtonUpdate()) {
            btnUpdate?.background = ContextCompat.getDrawable(this, R.drawable.bg_button_enable)
            btnUpdate?.setTextColor(ContextCompat.getColor(this, R.color.white))
        }
        else {
            btnUpdate?.background = ContextCompat.getDrawable(this, R.drawable.bg_button_disable)
            btnUpdate?.setTextColor(ContextCompat.getColor(this, R.color.black))
        }
    }
    private fun isEnableButtonUpdate() : Boolean {
        return edtFullname?.text.toString().trim().isNotEmpty() &&
                edtPhone?.text.toString().trim().isNotEmpty() &&
                tvDate?.text.toString().trim().isNotEmpty()
    }
}