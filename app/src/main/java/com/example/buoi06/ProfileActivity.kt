package com.example.buoi06

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.addTextChangedListener
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class ProfileActivity : AppCompatActivity(), DatePickerListener {
    private var hoTen: EditText? = null
    private var ngaySinh: EditText? = null
    private var soDt: EditText? = null
    private var email: EditText? = null
    private var cmt: EditText? = null
    private var btn_submit: Button? = null
    private var btn_pickTime: Button? = null

    private var name = ""
    private var dAte = ""
    private var sdt = ""
    private var mail = ""
    private var cmT = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        hoTen = findViewById(R.id.edt_name)
        ngaySinh = findViewById(R.id.edt_dob)
        soDt = findViewById(R.id.edt_sdt)
        email = findViewById(R.id.edt_email)
        cmt = findViewById(R.id.edt_cmt)
        btn_submit = findViewById(R.id.btn_update)
        btn_pickTime = findViewById(R.id.pickTime)

        btn_pickTime?.setOnClickListener {
            val datePickerFragment = DatepickerFragment()
            datePickerFragment.datePickerListener = this
            DatepickerFragment().show(supportFragmentManager, "timePicker")

        }

        hoTen?.addTextChangedListener {
            name = it.toString()
            btn_submit?.isEnabled = name.isNotEmpty() && dAte.isNotEmpty() && sdt.isNotEmpty() && mail.isNotEmpty() && cmT.isNotEmpty()
        }
        ngaySinh?.addTextChangedListener {
            btn_submit?.isEnabled = name.isNotEmpty() && dAte.isNotEmpty() && sdt.isNotEmpty() && mail.isNotEmpty() && cmT.isNotEmpty()
        }
        soDt?.addTextChangedListener {
            sdt = it.toString()
            var phoneNumber = soDt?.text.toString().trim()
            if (phoneNumber.length != 10){
                soDt?.setError("Số điện thoại tối đa 10 ký tự")
            }
            else {
                soDt?.setError(null)
            }
            btn_submit?.isEnabled = name.isNotEmpty() && dAte.isNotEmpty() && sdt.isNotEmpty() && mail.isNotEmpty() && cmT.isNotEmpty()
        }

        email?.addTextChangedListener {
            mail = it.toString()
            var comment = email?.text.toString().trim()
            if (!isValidEmail(comment)){
                email?.setError("Vui lòng nhập email hợp lệ!")
            }
            else {
                email?.setError(null)
            }
            btn_submit?.isEnabled = name.isNotEmpty() && dAte.isNotEmpty() && sdt.isNotEmpty() && mail.isNotEmpty() && cmT.isNotEmpty()
        }

        cmt?.addTextChangedListener {
            cmT = it.toString()
            var coment = cmt?.text.toString().trim()
            if (coment.length != 12){
                cmt?.setError("Nhập tối đa 12 ký tự")
            }
            else {
                cmt?.setError(null)
            }
            btn_submit?.isEnabled = name.isNotEmpty() && dAte.isNotEmpty() && sdt.isNotEmpty() && mail.isNotEmpty() && cmT.isNotEmpty()
        }


    }

    override fun onDateSet(date: Date) {
        val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        dAte = simpleDateFormat.format(date)
        ngaySinh?.setText(dAte)
        btn_submit?.isEnabled = name.isNotEmpty() && ngaySinh?.text.toString().isNotEmpty() && sdt.isNotEmpty() && mail.isNotEmpty() && cmT.isNotEmpty()
    }
}
fun isValidEmail(email: String) : Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}