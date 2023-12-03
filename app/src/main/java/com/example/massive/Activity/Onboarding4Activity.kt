package com.example.massive.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.massive.R

class Onboarding4Activity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding4)

        val btnMulai: Button = findViewById(R.id.btn_slnjutnya)
        btnMulai.setOnClickListener(this)

        val imgback: ImageView = findViewById(R.id.img_back)
        imgback.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id){
            R.id.btn_slnjutnya -> {
                val intent = Intent (this@Onboarding4Activity, LoginActivity::class.java)
                startActivity(intent)
            }

            R.id.img_back-> {
                val intent = Intent (this@Onboarding4Activity, Onboarding1Activity::class.java)
                startActivity(intent)
            }
        }
    }
}