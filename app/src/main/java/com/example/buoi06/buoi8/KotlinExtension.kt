package com.example.buoi06.buoi8

import android.view.View
import android.widget.Toast
import com.example.buoi06.SingleClickListener

//hàm mở rộng cho tất c những thứ được kế thừa ví dụ như ở dưới sẽ áp dujnhg cho tất cả những cái
//là view dunfg được cho nhiều cái khác nữa
fun View.setOnSingleClick(onClick: ((View?) -> Unit)) {
    setOnClickListener(object : SingleClickListener() {
        override fun onClick(view: View?) {
            super.onClick(view)
            onClick.invoke(view)
        }
    })
}

fun View.toastLinhTinh() {
    Toast.makeText(context, "Hihi", Toast.LENGTH_LONG).show()
}

//sử dụng thì gọi như bth, ví dụ btnOpen?.setsetOnSingleClick(){
//
//}