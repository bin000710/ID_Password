package com.example.id_password_07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat






class MainActivity : AppCompatActivity() {
    private lateinit var Button_login: Button
    private lateinit var et_ID: EditText
    private lateinit var et_password: EditText

    private var str1: String? = null
    private var str2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        et_ID = findViewById(R.id.et_ID)
        et_password = findViewById(R.id.et_password)
        Button_login = findViewById(R.id.Button_login)




        Button_login.setOnClickListener {

            str1 = et_ID.text.toString()
            if(str1.isNullOrEmpty()){
                Toast.makeText(applicationContext, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            else{
                str2 = et_password.text.toString()
                if(str2.isNullOrEmpty()){
                    Toast.makeText(applicationContext, "비밀번호를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                else{
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    intent.putExtra("str1", str1) // 인텐트에 문자열 추가
                    intent.putExtra("str2", str2)
                    startActivity(intent)
                }
            }



        }

    }
}