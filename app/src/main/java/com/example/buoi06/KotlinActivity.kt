package com.example.buoi06

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.log

class KotlinActivity : AppCompatActivity(), Onclick, View.OnClickListener {
    val count: Int = 0

    //biến var có gán giá trị mặc định
    var count1: Int = 0

    //biến var không gán giá trị mặc định
    var count2: Int? = null

    //Không khai báo kiểu dữ liu
    var count3 = 0f



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kotlin)
        tinhTong(10, 2)
        tinhHieu(10)

        val student = StudentKotlin(1)
        val student3 = StudentKotlin(1, "abc")
        //set dữ liệu
        student.name = "Nguyễn Tuấn Anh"
        student.age = 20
        student.high = 100
        //set d liệu kiểu 2
//        val student2 = StudentKotlin().apply {
//            this.name = "hihi"
//            this.age = 10
//            this.high = 5
//        }


        Toast
            .makeText(this,
                "Tên: " + student.name + "Tuổi: " + student.age,
                Toast.LENGTH_LONG)
            .show()

        if (student.age > 10){

        }
        //duyệt vòng for từ 1 đến 10
        for (i in 1..10){

        }

        val  students = ArrayList<StudentData>()
        students.add(StudentData("11", "10"))
        students.add(StudentData("11", "10"))
        students.add(StudentData("11", "10"))
        students.add(StudentData("11", "10"))
        students.add(StudentData("11", "10"))
        val studentList = mutableListOf<StudentData>()
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))
            studentList.add(StudentData("11", "10"))

        //duyệt vòng for
        for(i in 0..studentList.size){

        }

        for (stu: StudentData in studentList){

        }

        //hàm mở rộng của List(extension), it là 1 phần tử trong list
        studentList.forEach {
            it.name
        }

        //duyệt vòng for có trả kèm vị trí cho từng phần tuwr
        studentList.forEachIndexed { index, studentData ->

        }

        //một số hàm khác
        //hàm lọc với bộ lọc là name == "abc" thì trả về 1 list khác dữ liệu
        studentList.filter { it.name == "abc" }
        //trả về phần tử đầu tiên có tên == "abc", nếu không có trả về null
        studentList.firstOrNull {it.name == "abc"}

    }

    private fun logLinhTinh(result: String, result2: String){

    }

    private fun tinhTong(a: Int, b: Int): Int {
        return a + b
    }

    //trong trường hợp không truyền giá trị của B thì giá trị của B mặc định là 1
    //trong trường hợp có dấu ? nghĩa là giá trị của biến đó có thể là null
    private fun tinhHieu (a: Int?, b: Int = 1): Int? {
        return a?.div(b)
    }

    //viết ngắn gọn
    private fun tinhTong2(a: Int, b: Int) = a + b
    override fun onClicked() {

    }

    override fun onClick(p0: View?) {

    }
    //các cách viết kiểu when
    private fun vietWhen() {
        //đối tượng không đổi, chỉ có giá trị bên trong thay đổi nên để đối tượng là val
        val student = StudentKotlin(10)
        when {
            student.age == 1 && student.name == "a" -> {
                Log.d("hihihi", "heheheh")
            }
            student.age == 2 -> {

            }
            else -> {

            }
        }
        //cách 2
        when(student.age) {
            1 -> {

            }
            2 -> {

            }
            else -> {

            }
        }
    }

    //$ten_bien (cong chuoi string)
    //${nhân, chia, ... 1 hàm bất kỳ} khi thực hiện xong phần trong ngoặc nhọn thì mới thực hiện
//    cộng chuỗi
    private fun xuLyChuoi(){
        val a = "abc"
        val b = "bcd"
        val c = "$a$b" //kết quả là abcbcd
        val d = 100 * 10
        val e = a + d //kết quả là "abc1000"
        val f = "$a${100 * 10}${199-10} tôi tên là: ${getTen()}" //kết quả "abc1000"
        val g = "abc"
        //áp dụng cho string và list
        g.isNotEmpty() //biến g có thể rỗng hay không: false -> đang rỗng
        g.isEmpty() //biến g có thể rỗng hay không: -> true -> đang rỗng
        g.isNullOrEmpty() //biến g có thể null hoặc rỗng hay không: true -> null hoặc rỗng
    }

    private fun getTen(): String {
        return "Dũng"
    }
}