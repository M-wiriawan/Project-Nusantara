package com.example.massive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PanitiaEvent.newInstance] factory method to
 * create an instance of this fragment.
 */
class PanitiaEvent : Fragment(), View.OnClickListener {
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
        return inflater.inflate(R.layout.fragment_panitia_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rapat: TextView = view.findViewById(R.id.tv_agenda)
        rapat.setOnClickListener(this)

        val detail: TextView = view.findViewById(R.id.tv_detail)
        detail.setOnClickListener(this)

        val dana: TextView = view.findViewById(R.id.tv_anggaran)
        dana.setOnClickListener(this)

        val checklist: TextView = view.findViewById(R.id.tv_chekclist)
        checklist.setOnClickListener(this)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PanitiaEvent.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PanitiaEvent().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.tv_agenda) {
            val rapat = AgendaFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, rapat, AgendaFragment::class.java.simpleName)
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

        if (v?.id == R.id.tv_detail) {
            val detail = DetailEvent()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, detail, DetailEvent::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }

        if (v?.id == R.id.tv_chekclist) {
            val check = CheckListFragment()
            val fragmentManager = parentFragmentManager
            fragmentManager.beginTransaction().apply {
                replace(R.id.framelayout, check, CheckListFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}