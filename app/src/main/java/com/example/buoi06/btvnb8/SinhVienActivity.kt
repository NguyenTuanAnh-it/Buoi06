package com.example.buoi06.btvnb8

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R
import com.example.buoi06.buoi8.AppRoomDatabase

class SinhVienActivity : AppCompatActivity() {
    companion object {
        //Những hằng số sẽ được khai báo ở đây, có thể gọi ở mọi chỗ, giống biến static
        const val KEY = "KEY"
        const val TYPE_EDIT = "EDIT"
        const val TYPE_ADD = "ADD"
        const val TYPE_DELETE = "DELETE"
    }
    private var sinhVienList: ArrayList<SinhVien> = ArrayList()
    private lateinit var rcvData: RecyclerView
    private lateinit var btnAdd: ImageButton
    private var sinhVienAdapter: SinhVienAdapter? = null
    private var userDao: UserDao? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sinh_vien)
        rcvData = findViewById(R.id.rcvData)
        btnAdd = findViewById(R.id.ivPlus)

        userDao = AppRoomDatabase.getDatabase(this).userDao()
        sinhVienList = (userDao?.getAllUser() as? ArrayList<SinhVien>) ?: ArrayList()

        sinhVienAdapter = SinhVienAdapter(sinhVienList, this)
        rcvData.adapter = sinhVienAdapter
        rcvData.layoutManager = LinearLayoutManager(this)

        btnAdd?.setOnClickListener {
            val intent = Intent(this, AddSinhVienActivity::class.java)
            startForResult.launch(intent)
        }

//       sinhVienAdapter?.onClickItem = { sinhVien, position ->
//           openEdit(sinhVien)
//       }

        sinhVienAdapter?.onRemoveItem = {
            sinhVienList.removeAt(it)
            sinhVienAdapter?.notifyDataSetChanged()
        }

    }



    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val name: String? = result.data?.extras?.getString("name")
                val address: String? = result.data?.extras?.getString("address")
                val phone:String? = result.data?.extras?.getString("phone")
                val sinhvien = SinhVien(
                    id = System.currentTimeMillis(),
                    name = name ?: "",
                    addRess = address ?: "",
                    phone = phone ?: ""
                )
                userDao?.insert(sinhvien)
                updateData()

                }
//                else if (type == TYPE_EDIT){
//                    val sinhvien = result.data?.extras?.get("sinhvien") as SinhVien
//                    if (sinhvien != null){
//                        for (item in sinhVienList){
//                            if (item.id == sinhvien.id){
//                                item.name = sinhvien.name
//                                item.addRess = sinhvien.addRess
//                                item.phone = sinhvien.phone
//                                break
//                            }
//                        }
//                    }
//                    sinhVienAdapter?.notifyDataSetChanged()
//                }

            }

    private fun updateData() {
        sinhVienList = userDao?.getAllUser() as ArrayList<SinhVien>
        sinhVienAdapter?.setArrayList(sinhVienList)
        sinhVienAdapter?.notifyDataSetChanged()
    }
}

//    private fun openAdd(){
//
//    }
//
//    private fun openEdit(sinhvien: SinhVien) {
//        val intent = Intent(this, EditSinhVienActivity::class.java)
//        intent.putExtra("sinhvien", sinhvien)
//        startForResult.launch(intent)
//    }










