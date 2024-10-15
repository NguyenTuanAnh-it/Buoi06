package com.example.buoi06.buoi6

import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.buoi06.R

class StudentKotlinAdapter: Adapter<StudentKotlinAdapter.StudentVH>() {
    class StudentVH(view: View): ViewHolder(view){
        private val tvName = view.findViewById<TextView>(R.id.tvName)

        fun setData(student: Student){
            tvName.text = student.name

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentVH {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: StudentVH, position: Int) {
        TODO("Not yet implemented")
    }
}

private fun goiApiTinhABC(callback: ((String) -> Unit)){
    //gọi api
    //tính toán linh tinh gì đấy
    tinhTong(1, 2)
    giaiPhuongTrinh()
    //sau khi làm xong mọi việc thì báo là đã ok việc
    callback.invoke("Thành Cong")
}