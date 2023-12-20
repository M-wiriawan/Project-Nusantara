package com.example.massive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.massive.retrofit.ApiEndpoint
import com.example.massive.retrofit.RetrofitClient
import com.github.dhaval2404.imagepicker.ImagePicker


class BuatEventFragment : Fragment() {

    private lateinit var textViewgambar: TextView
    private lateinit var imageViewgambar: ImageView
    private lateinit var button: Button
//
//    private val apiInterface: ApiEn =
//        RetrofitClient.getApiClient().create(ApiInterface::class.java)

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_buat_event, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val imgBack: ImageView = view.findViewById(R.id.back)
//        imgBack.setOnClickListener(this)
//
//        val buat_event: Button = view.findViewById(R.id.buat_event)
//        buat_event.setOnClickListener(this)
//
//    }
//
//
//    override fun onClick(v: View?) {
//        if (v?.id == R.id.back) {
//            val back = Beranda()
//            val fragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().apply {
//                replace(R.id.framelayout, back, Beranda::class.java.simpleName)
//                addToBackStack(null)
//                commit()
//            }
//        }
//
//        if (v?.id == R.id.buat_event) {
//            val buatevent = DetailEvent()
//            val fragmentManager = parentFragmentManager
//            fragmentManager.beginTransaction().apply {
//                replace(R.id.framelayout, buatevent, DetailEvent::class.java.simpleName)
//                addToBackStack(null)
//                commit()
//            }
//        }
//    }

        private lateinit var editTextViewacara: TextView
        private lateinit var imageViewacara: ImageView

        private val apiEndpoint: ApiEndpoint =
                RetrofitClient.getApiClient().create(ApiEndpoint::class.java)
        
        private val IMAGE_PICKER_REQUEST_CODE_ACARA = 1

        override fun onCreateView(
                inflater: LayoutInflater, container: ViewGroup?,
                savedInstanceState: Bundle?
        ): View? {
                return inflater.inflate(R.layout.fragment_buat_event, container, false)
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                
                editTextViewacara = view.findViewById(R.id.ev_gambar)
                imageViewacara = view.findViewById(R.id.iv_input_gambar)
                
                imageViewacara.setOnClickListener { 
                        startImagePicker(IMAGE_PICKER_REQUEST_CODE_ACARA)
                }
        }

        private fun startImagePicker(imagePickerRequestCodeAcara: Int) {
                ImagePicker.with(this)
                        .crop()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start(imagePickerRequestCodeAcara)
        }


}