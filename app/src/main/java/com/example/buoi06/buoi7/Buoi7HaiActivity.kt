package com.example.buoi06.buoi7

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R

class Buoi7HaiActivity : AppCompatActivity() {
    //Hiển thị dữ liệu từ màn trước truyền sang
    private  var tvShowData: TextView? = null
    //bấm vào back lại màn trước và truyền dữ liệu ngược lại
    private  var btnBack: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7_hai)
        tvShowData = findViewById(R.id.showData)
        btnBack = findViewById(R.id.btnBack)

        //nhận dữ liệu
        val so = intent.extras?.getInt("key1", -1)
        val text = intent.extras?.getString("key2", "")
        val data = intent.extras?.get("key3") as? SevenData
        val textString = "$text _ $so \n ${data?.title} \n ${data?.content}"

        tvShowData?.text = textString

        btnBack?.setOnClickListener {
//            truyền ngược lại màn trước
            val intent = Intent()
            intent.putExtra("key4", 1)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}