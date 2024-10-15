package com.example.buoi06.buoi8

import android.content.Context
import android.content.Context.MODE_PRIVATE

object SharePreferentUltils {
    fun saveName(name: String, context: Context){
        //lệnh lấy preferent bằng context
        val preferences = context.getSharedPreferences("abc", MODE_PRIVATE)
        //lưu dữ liệu string bằng key name
        preferences.edit().putString("name", name).apply()
    }

    fun getName(context: Context) : String {
        //lệnh lấu preferences bằng context
        val preferences = context.getSharedPreferences("abc", MODE_PRIVATE)
        //lấy dữ liệu, nếu không có dữ liệu trả về "" tránh bị null crash app
        return preferences.getString("name", "")?:""
    }
}