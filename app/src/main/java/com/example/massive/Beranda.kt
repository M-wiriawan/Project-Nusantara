package com.example.massive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView


class Beranda : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgNotifikasi: ImageView = view.findViewById(R.id.img_notif)
        imgNotifikasi.setOnClickListener(this)

        val btnevent: Button = view.findViewById(R.id.btn_buatevent)
        btnevent.setOnClickListener(this)

        val btngabungevent: Button = view.findViewById(R.id.btn_gbngevent)
        btngabungevent.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.img_notif) {
            val notifikasi = Notifikasi()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, notifikasi, Notifikasi::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
        if (v?.id == R.id.btn_buatevent) {
            val buatevent = BuatEventFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, buatevent, BuatEventFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if (v?.id == R.id.btn_gbngevent) {
            val gabungevent = GabungEventFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, gabungevent, GabungEventFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

    }
}