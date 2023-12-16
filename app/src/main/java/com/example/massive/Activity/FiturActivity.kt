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

        val Beranda= Beranda()
        val EventAktif= EventAktif()
        val Profile= Profile()

        setCurrentFragment(Beranda)

        bottomNavigationView = findViewById(R.id.bottom_navigasi)
        bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.beranda -> setCurrentFragment(Beranda)
                R.id.event -> setCurrentFragment(EventAktif)
                R.id.profil -> setCurrentFragment(Profile)
            }

//            if (selectedFragment != null) {
//                val fragmentManager: FragmentManager = supportFragmentManager
//                fragmentManager.beginTransaction()
//                    .replace(R.id.framelayout, selectedFragment)
//                    .commit()
//            }

            true
        }
    }

    private fun setCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.framelayout,fragment)
            commit()
        }
}