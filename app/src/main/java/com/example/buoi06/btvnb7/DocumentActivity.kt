package com.example.buoi06.btvnb7

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buoi06.R
import com.example.buoi06.buoi7.Buoi7Fragment

class DocumentActivity : AppCompatActivity() {

    companion object {
        //Những hằng số sẽ được khai báo ở đây, có thể gọi ở mọi chỗ, giống biến static
        const val KEY = "KEY"
        const val TYPE_EDIT = "EDIT"
        const val TYPE_ADD = "ADD"
    }
    private val documentList: ArrayList<Document> = ArrayList()
    private lateinit var rcvData: RecyclerView
    private var tvAdd: TextView? = null
    private var documentAdapter: DocumentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_document)
        rcvData = findViewById(R.id.rcvData)
        tvAdd = findViewById(R.id.tvAdd)

        //nhớ khởi tạo cho adapter
        documentAdapter = DocumentAdapter(addData(), this)
        //tiếp là gán recycleview.adapter cho adapter
        rcvData.adapter = this.documentAdapter
        rcvData.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        documentAdapter?.onClickItem = { document, position ->
            openAddDocument(document)
        }

        tvAdd?.setOnClickListener {
            val intent = Intent(this, AddDocumentActivity::class.java)
            startForResult.launch(intent)
        }

    }

    fun addData(): ArrayList<Document> {
        documentList.add(Document(1,  "Tổng hợp tin tức thời sự", "Tổng hợp tin tức nóng hổi nhất của..."))
        documentList.add(Document(2,  "Tổng hợp tin tức thời sự", "Tổng hợp tin tức nóng hổi nhất của..."))
        documentList.add(Document(3, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức nóng hổi nhất của..."))
        documentList.add(Document(4, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức nóng hổi nhất của..."))
        documentList.add(Document(5, "Tổng hợp tin tức thời sự", "Tổng hợp tin tức nóng hổi nhất của..."))
        return documentList
    }

    private fun openAddDocument(document: Document) {
        val intent = Intent(this, EditDocumentActivity::class.java)
        intent.putExtra("document", document)
        startForResult.launch(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    private val startForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                val type = result.data?.extras?.getString(KEY)
                if (type == TYPE_ADD) {
                    val document = result.data?.extras?.get("document") as? Document
                    if (document != null) {
                        documentList.add(document)
                    }
                    documentAdapter?.notifyDataSetChanged()
                }
                else if (type == TYPE_EDIT) {
                    val document = result.data?.extras?.get("document") as? Document
                    if (document != null){
                        //cập nhật lại dữ liệu cho documentList
                        for (item in documentList){
                            if (item.id == document.id) {
                                item.title = document.title
                                item.content = document.content
                                break
                            }
                        }
                        documentAdapter?.notifyDataSetChanged()
                    }
                }
            }
        }
    }