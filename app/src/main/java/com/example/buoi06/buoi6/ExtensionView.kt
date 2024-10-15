package com.example.buoi06.buoi6

import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.buoi06.R


//Trong extension được sử dụng tất carcacs hàm, thuộc tính
//của đối tượng mà extension hướng đến
fun TextView.showName(){
    text = "Nguyễn"
    setTextColor(ContextCompat.getColor(context, R.color.black))
}

fun Student.showData(): String{
    return  "$name $age"
}