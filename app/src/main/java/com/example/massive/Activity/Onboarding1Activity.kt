package com.example.massive.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.massive.R

class Onboarding1Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding1)

        val btnSelanjutnya: Button = findViewById(R.id.btn_slnjut)
        btnSelanjutnya.setOnClickListener(this)

        val btnLewat: Button = findViewById(R.id.btn_lwt)
        btnLewat.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id){

            R.id.btn_slnjut -> {
                val intent = Intent (this@Onboarding1Activity, Onboarding2Activity::class.java)
                startActivity(intent)
            }

            R.id.btn_lwt -> {
                val intent = Intent (this@Onboarding1Activity, Onboarding4Activity::class.java)
                startActivity(intent)
            }

        }
    }


}