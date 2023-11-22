package com.example.massive.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.massive.Beranda
import com.example.massive.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    private lateinit var etemail: EditText
    private lateinit var etkatasandi: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etemail = findViewById(R.id.et_email)
        etkatasandi = findViewById(R.id.et_katasandi)

        val btnMulai: Button = findViewById(R.id.btn_masuk1)
        btnMulai.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {

            R.id.btn_masuk1 -> {
                val intent = Intent(this@LoginActivity, Beranda::class.java)
                startActivity(intent)
            }
        }
    }
}
