package com.example.id_password_07

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date

class ResultActivity : AppCompatActivity() {

    private lateinit var save_result: TextView
    private lateinit var save_time: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        save_result = findViewById(R.id.save_result)
        save_time= findViewById(R.id.save_time)

        val intent = intent
        val str_ID = intent.getStringExtra("str1")
        val str_Password = intent.getStringExtra("str2")

        val currentTime = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val formattedTime = dateFormat.format(currentTime)


        save_result.text = " 아이디: $str_ID \n 비밀번호: $str_Password 님\n 로그인 되었습니다."
        save_time.text="시간: $formattedTime  "
    }
}