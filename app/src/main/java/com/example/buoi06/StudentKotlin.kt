package com.example.buoi06

class StudentKotlin constructor(var high: Int, gender: String = "name"): StudentBase() {

     var name: String = ""
     var age: Int = 0
     init {
         //đây là hàm được gọi khi bắt đầu khởi tạo đối thượng
          age = 100
     }


}