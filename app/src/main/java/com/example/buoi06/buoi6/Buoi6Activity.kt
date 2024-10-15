package com.example.buoi06.buoi6

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R

class Buoi6Activity : AppCompatActivity() {
    //Lamda function
    //((Kiểu dữ liệu) -> Unit
    //Kiểu dữ liệu có thể có hoặc không
    private var print: (() -> Unit) = {
        Toast.makeText(this, "HIHI", Toast.LENGTH_SHORT).show()
    }


    private var print2: ((String) -> Unit) = {
        Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buoi6)
        tinhTong(1, 2)
        print2.invoke("Tao là Dũng")
        Database.xoaDuLieu()
        Database.suaDuLieu()

//        if (student != null){
//            todo
//        }


        student?.let {
            // TODO: it
            //cái let này để kiểm tra xem cái student có bị null hay lỗi không sau đ trả về biến it
            print(it.name)
        }

        val chat = Chat().apply {
            this.image = R.drawable.ic_person
            this.title = "Nguyen Tuan Anh"
            this.content ="hhskjdhaskjhd"
        }
    }


}

private fun createStudentList() : List<Student2> {
    val studentlist: MutableList<Student2> = ArrayList()
    val studentItem = Student2().apply {
        //apply này để khởi tạo đối tượng thông qua hàm khởi tạo không tham số
        this.name = "HIHI"
        this.age = "20"
    }

    studentlist.add(studentItem)

    return  studentlist
}

private var student: Student2? = null

//cái này là Singleton
object Database {
    fun xoaDuLieu(){
        //java thì gọi như sau: Database.INSTANCE.xoaDuLieu();
    }

    fun suaDuLieu() {

    }
}