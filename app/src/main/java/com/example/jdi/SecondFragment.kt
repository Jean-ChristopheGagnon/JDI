package com.example.jdi


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.fragment.app.FragmentManager
import java.util.*

class SecondFragment : Fragment() {

    // inflate the layout
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_second, container, false)



//        parentFragmentManager.beginTransaction().replace(R.id.form_container, CategoriesFragment(), tag).commit()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonClick = requireView().findViewById<Button>(R.id.creer_categorie)
        buttonClick.setOnClickListener() {
            val intent = Intent(context, CreerCategorieActivity::class.java)
            startActivity(intent)
        }



    }
}

