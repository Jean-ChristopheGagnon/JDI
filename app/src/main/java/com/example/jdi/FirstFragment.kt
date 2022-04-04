package com.example.jdi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import java.io.File

class FirstFragment() : Fragment() {
    // inflate the layout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_first, container, false)
        parentFragmentManager.beginTransaction().replace(R.id.note_container, NotesFragment(), tag).commit()

        return view
    }
}