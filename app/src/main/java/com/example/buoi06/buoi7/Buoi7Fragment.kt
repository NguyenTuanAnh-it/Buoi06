package com.example.buoi06.buoi7

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.buoi06.R


class Buoi7Fragment : Fragment() {



    //viết trong đây dễ maintain code
    companion object {
        //Viết các key, các hằng viết trong companion object
        const val NAME = "Nguyễn Tuấn Anh"

        fun newFragment(data: String): Buoi7Fragment {
            val fragment = Buoi7Fragment()
            val bundle = Bundle()
            bundle.putString("key5", data)
            bundle.putString("key6", data)
            bundle.putString("key7", data)
            bundle.putString("key8", data)
            bundle.putString("key9", data)
            fragment.arguments = bundle
            return fragment
        }
    }

    private var btnClickMe: Button? = null
    //khởi tạo 1 fragment được gọi 1 lần
    //set Style, theme cho từng fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    //tạo view cho fragment
    //chỉ được gọi 1 lần
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buoi7, container, false)
    }

    //khi view khởi tạo xong
    //khởi tạo dữ liệu, gọi api, findviewbyid
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //muốn gọi activity cha, sau đó ép kiểu về activity mà chúng ta muốn
//ép kiểu theo kiểu không dấu ? dễ bị lỗi khi ép kiểu bị null
//        (activity as Buoi7Activity) ép kiểu từ activity về Buoi7Activity

        //trong trường hợp ép kểu thất bại thì kết quả trả về là null

        btnClickMe = view.findViewById(R.id.btnClickMe)
        btnClickMe?.setOnClickListener {
            (activity as? Buoi7Activity)?.ToastLinhTinh("Đây là truyền ngược lại")
        }

        val text = arguments?.getString("key5", "")
        btnClickMe?.text = text
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }


    //hủy view trước khi hủy fragment
    //khi các bạn cần lấy 1 số dữ liệu từ trên view trước khi chúng bị hủy
    override fun onDestroyView() {
        super.onDestroyView()
    }

    //chính thức hủy fragment
    override fun onDestroy() {
        super.onDestroy()
    }


    //detach khỏi activity
    override fun onDetach() {
        super.onDetach()
    }
}