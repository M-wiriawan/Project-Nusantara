package com.example.massive.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.massive.R

class Registrasi : AppCompatActivity(), View.OnClickListener {

    private lateinit var etemail: EditText
    private lateinit var etkatasandi: EditText
    private lateinit var etkatasandi2: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

//        etemail = findViewById(R.id.edt_email)
//        etkatasandi = findViewById(R.id.edt_sandi)
//        etkatasandi2 = findViewById(R.id.edt_sandi2)

        val btnMulai: Button = findViewById(R.id.btn_masuk)
        btnMulai.setOnClickListener(this)

        val tvlogin: TextView = findViewById(R.id.tv_login)
        tvlogin.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_masuk -> {
                val intent = Intent(this@Registrasi, FiturActivity::class.java)
                startActivity(intent)
            }

            R.id.tv_login -> {
                val intent = Intent(this@Registrasi, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}