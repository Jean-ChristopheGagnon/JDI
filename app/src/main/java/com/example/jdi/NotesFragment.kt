package com.example.jdi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment


class NotesFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater!!.inflate(R.layout.fragment_notes, container, false)
        val notes = (activity as MainActivity?)!!.queryNotesFromDBM()
        var button_Id : Int = 0
        if (notes != null) {
            for(note in notes){
                val button = Button((activity as MainActivity?)!!)
                button.setText(note.titreNote)
                button.setLayoutParams(ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT))
                button.setId(button_Id)
                button.y = button_Id*150f
                button.setOnClickListener(this)
                view.rootView.findViewById<RelativeLayout>(R.id.button_container).addView(button)
                ++button_Id
            }
        }
        return view
    }
    override fun onResume() {
        super.onResume()
    }
}

private fun Button.setOnClickListener(notesFragment: NotesFragment) {

}
