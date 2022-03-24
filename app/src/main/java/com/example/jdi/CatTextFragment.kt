package com.example.jdi

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.io.File

class CatTextFragment : Fragment() {
    lateinit var et_text : EditText
    lateinit var btn_save_cat_text: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_cat_text, container, false)



        btn_save_cat_text = view.findViewById(R.id.btn_save_cat_text)
        btn_save_cat_text.setOnClickListener {

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