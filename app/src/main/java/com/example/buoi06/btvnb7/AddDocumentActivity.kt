package com.example.buoi06.btvnb7

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.buoi06.R

class AddDocumentActivity : AppCompatActivity() {
    private var tvSave: TextView? = null;
    private var tvCancel: TextView? = null;
    private var edtNameDocument: EditText? = null;
    private var edtDescriptionDocument: EditText? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_document)

        tvSave = findViewById(R.id.tvAdd)
        tvCancel = findViewById(R.id.tvCancel)
        edtNameDocument = findViewById(R.id.edtNameDoc)
        edtDescriptionDocument = findViewById(R.id.edtDescription)

        tvSave?.setOnClickListener {
            //muốn gửi dữ liệu từ màn 3 này về màn 1 thì
            //b1: tạo đối tượng document ra xong intent bắn ngược về là ok
            val document = Document(
                id = System.currentTimeMillis().toInt(), //lấy thời gian hiện tại lấy id cho nó khác ý mà
//                image = R.drawable.ic_document,
                title = edtNameDocument?.text.toString(),
                content = edtDescriptionDocument?.text.toString()
            )

            val intent = Intent()
            intent.putExtra("document", document)
            intent.putExtra(DocumentActivity.KEY, DocumentActivity.TYPE_ADD)
            setResult(RESULT_OK, intent)
            finish()


        }

    }
}