package com.example.jdi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.io.File

class FirstFragment : Fragment() {
    // inflate the layout
    lateinit var tv_display_note : TextView;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_first, container, false)

        val file = File(requireContext().filesDir, "noteFile.txt")
        val contents = file.readText()

        tv_display_note = view.findViewById(R.id.tv_display_note)
        tv_display_note.text = contents




        return view
    }
}