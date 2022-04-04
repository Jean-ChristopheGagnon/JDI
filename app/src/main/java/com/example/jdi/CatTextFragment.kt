package com.example.jdi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.jdi.model.Champ
import com.example.jdi.model.Couple
import io.realm.RealmList

class CatTextFragment : Fragment() {
    lateinit var et_text : EditText
    lateinit var btn_save_cat_text: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater!!.inflate(R.layout.fragment_cat_text, container, false)

        et_text = view.findViewById(R.id.et_text)

        btn_save_cat_text = view.findViewById(R.id.btn_save_cat_text)
        btn_save_cat_text.setOnClickListener {
            saveUserInput()
        }

        return view
    }

    fun saveUserInput() {
        var champ : Champ = Champ()
        champ.nomChamp = "Champ texte"
        champ.estObligatoire = true
        champ.typeReponse = "Champ texte"
        var couple : Couple = Couple(champ, et_text.text.toString(), null, null, null, null)
        var listeCouple: RealmList<Couple> = RealmList()
        listeCouple.add(couple)
        (activity as MainActivity?)!!.passListToDBM(listeCouple, et_text.text.toString(), "0")
    }
}