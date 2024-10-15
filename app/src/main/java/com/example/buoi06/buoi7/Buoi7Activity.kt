package com.example.buoi06.buoi7

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R

class Buoi7Activity : AppCompatActivity() {
    private var flFragment1: FrameLayout? = null
    private var btnOpen: Button? = null

    //Truyền ngược từ màn Buoi7Hai về màn Buoi7
    //Dùng khi cần gọi đến các thứ mặc định trong máy(vd: chọn ảnh, chụp ảnh,...)
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val so = result.data?.extras?.getInt("key4")
                Toast.makeText(this, "$so", Toast.LENGTH_SHORT).show()
            }
        }

    //Khởi tạo, set findViewById, chỉ được gọi 1 lần(call api)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi7)

        flFragment1 = findViewById(R.id.flFragment1)
        btnOpen = findViewById(R.id.btnOpen)

        openManMoi()
        val fragment1 = Buoi7Fragment.newFragment("Đây là DATA")
        Buoi7Fragment.NAME
//        val fragment2 = Buoi7HaiFragment()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.flFragment1, fragment1, fragment1.tag).commitAllowingStateLoss()
//        fragmentTransaction.add(R.id.flFragment2, fragment2).commit()


    }

    //hàm được gọi nhiều lần
    override fun onStart() {
        super.onStart()
    }

    //Sau hàm onResume thì chúng ta có thể thấy 1 màn hình
    //được gọi nhiều lần, có thể xử lý 1 số logic cần khi app quay trở lại foreground
    override fun onResume() {
        super.onResume()
    }

    //hàm khi app được xuống background(các bạn cần lưu lại 1 số dữ liệu gì đó để khi
    //app từ background ln foreground nó hiển thị luôn)
    //foreground là phần mình nhìn thấy
    override fun onPause() {
        super.onPause()
    }


    override fun onStop() {
        super.onStop()
    }


    //Hủy activity (hệ thống android kill app, do chúng ta gọi)
    //remove hoặc clear một số observe, 1 số luồng call api dang dở, 1 số sự kiện
    //tiết kiệm bộ nhớ, tránh leak memory
    override fun onDestroy() {
        super.onDestroy()

    }

    fun ToastLinhTinh(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun openManMoi() {
        btnOpen?.setOnClickListener {

            val intent = Intent(this, Buoi7HaiActivity::class.java)
            //truyền dữ liệu kểu int
            intent.putExtra("key1", 10)
            //truyền dữ liệu kểu String
            intent.putExtra("key2", "Tao tên là Dũng")
            val data = SevenData().apply {
                this.title = "Đây là title"
                this.content = "Đây là content"
            }

            intent.putExtra("key3", data)
//            startActivity(intent)
            startForResult.launch(intent)
        }
    }
}