package com.example.jdi


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import java.util.*

class SecondFragment : Fragment() {


    lateinit var btn_cat_text : Button;
    lateinit var et_text : EditText;

    // inflate the layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_second, container, false)

        et_text = view.findViewById(R.id.et_text)

        btn_cat_text = view.findViewById(R.id.btn_cat_text)
        btn_cat_text.setOnClickListener {
            saveUserInput(et_text.text.toString())
        }



        return view
    }

    fun saveUserInput(note: String) {
        context?.openFileOutput("noteFile.txt", Context.MODE_PRIVATE).use {
            if (it != null) {
                it.write(note.toByteArray())
            }
        }
    }
}

