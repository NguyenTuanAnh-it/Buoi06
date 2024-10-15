package com.example.buoi06
//Thường sử dụng khi tạo model từ api trả về
class StudentData(
    var name: String,
    var age: String
){
    var high: Int = 0

    fun inRaChieuCao() {
        print("$name: $high")
    }
}