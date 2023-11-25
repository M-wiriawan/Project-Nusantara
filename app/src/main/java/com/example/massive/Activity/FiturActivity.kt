package com.example.massive.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.massive.Beranda
import com.example.massive.EventAktif
import com.example.massive.Profile
import com.example.massive.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class FiturActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitur)


        bottomNavigationView = findViewById(R.id.bottom_navigasi)
        bottomNavigationView.setOnNavigationItemSelectedListener {item ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.beranda -> selectedFragment = Beranda()
                R.id.event -> selectedFragment = EventAktif()
                R.id.profil -> selectedFragment = Profile()
            }

            if (selectedFragment != null) {
                val fragmentManager: FragmentManager = supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.framelayout, selectedFragment)
                    .commit()
            }

            true
        }
    }


}