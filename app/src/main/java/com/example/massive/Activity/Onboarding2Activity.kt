package com.example.massive.Activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.massive.R

class Onboarding2Activity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        val btnSelanjutnya: Button = findViewById(R.id.btn_slnjut)
        btnSelanjutnya.setOnClickListener(this)

        val btnLewat: Button = findViewById(R.id.btn_lwt)
        btnLewat.setOnClickListener(this)

        val imgback: ImageView = findViewById(R.id.img_back)
        imgback.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){

            R.id.btn_slnjut -> {
                val intent = Intent (this@Onboarding2Activity, Onboarding3Activity::class.java)
                startActivity(intent)
            }

            R.id.btn_lwt -> {
                val intent = Intent (this@Onboarding2Activity, Onboarding4Activity::class.java)
                startActivity(intent)
            }

            R.id.img_back-> {
                val intent = Intent (this@Onboarding2Activity, Onboarding1Activity::class.java)
                startActivity(intent)
            }

        }
    }
}