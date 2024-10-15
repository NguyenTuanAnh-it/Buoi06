package com.example.buoi06.btvnb7

import android.app.Activity
import android.content.Intent
import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R

class EditDocumentActivity : AppCompatActivity() {
    private var edtNameDocument: EditText? = null
    private var edtDescription: EditText? = null
    private var save: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_document)
        edtNameDocument = findViewById(R.id.edtNameDoc)
        edtDescription = findViewById(R.id.edtDescription)
        save = findViewById(R.id.tvAdd)

        //tạo biến nhận dữ liệu truyền sang
        val document = intent.extras?.get("document") as? Document
        if (document != null) {
            edtNameDocument?.setText(document.title)
            edtDescription?.setText(document.content)
        }

        save?.setOnClickListener {
            if (document != null) {
                putDataIntDocument(document)
            }
        }


    }

    fun putDataIntDocument(document: Document) {
        //set lại các giá trị title, content cho biến folder để truyền ngược về màn 1
        //?:"", nghĩa là khi cái edtNameDocument?.text.toString() bị null thì title = ""
        document?.title = edtNameDocument?.text.toString() ?:""
        document?.content = edtDescription?.text.toString() ?:""
        val intent = Intent()
        intent.putExtra("document", document)
        intent.putExtra(DocumentActivity.KEY, DocumentActivity.TYPE_EDIT)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }


}