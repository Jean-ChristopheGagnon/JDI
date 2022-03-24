package com.example.jdi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class CategoriesFragment : Fragment() {

    lateinit var btn_cat_text : Button
    lateinit var btn_cat_dream : Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_categories, container, false)



        btn_cat_text = view.findViewById(R.id.btn_cat_text)
        btn_cat_text.setOnClickListener {
            loadCatFragment(CatTextFragment(), view)
        }

        btn_cat_dream = view.findViewById(R.id.btn_cat_dream)
        btn_cat_dream.setOnClickListener {
            loadCatFragment(CatDreamFragment(), view)
        }



        return view
    }

    fun loadCatFragment(fragment : Fragment, view : View){
        val tag = "back"
        parentFragmentManager.beginTransaction().replace(R.id.form_container, fragment, tag).addToBackStack(tag).commit()
    }
}