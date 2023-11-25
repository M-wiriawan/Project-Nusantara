package com.example.massive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Beranda.newInstance] factory method to
 * create an instance of this fragment.
 */
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
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.img_notif) {
            val imgnotifikasi = Notifikasi()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.img_notif, imgnotifikasi, Notifikasi::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}