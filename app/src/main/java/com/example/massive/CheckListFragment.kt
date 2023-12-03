package com.example.massive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CheckListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CheckListFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val panitia: TextView = view.findViewById(R.id.tv_panitia)
        panitia.setOnClickListener(this)

        val agenda: TextView = view.findViewById(R.id.tv_agenda)
        agenda.setOnClickListener(this)

        val anggaran: TextView = view.findViewById(R.id.tv_anggaran)
        anggaran.setOnClickListener(this)

        val detail: TextView = view.findViewById(R.id.tv_detail)
        detail.setOnClickListener(this)

        val tambah: Button = view.findViewById(R.id.btn_tambah)
        tambah.setOnClickListener(this)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CheckListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CheckListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.tv_panitia) {
            val panitia = PanitiaEvent()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, panitia, PanitiaEvent::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if (v?.id == R.id.tv_anggaran) {
            val anggaran = AnggaranFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, anggaran, AnggaranFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if (v?.id == R.id.tv_agenda) {
            val agenda = AgendaFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, agenda, AgendaFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }


        if (v?.id == R.id.tv_detail) {
            val detail = DetailEvent()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, detail, DetailEvent::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if (v?.id == R.id.btn_tambah) {
            val tambah = Check2Fragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, tambah, Check2Fragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}