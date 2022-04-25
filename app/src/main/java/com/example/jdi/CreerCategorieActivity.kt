package com.example.jdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CreerCategorieActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<CreationCategorieChampsRVAdapter.ViewHolder>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creer_categorie)

        val recycler = findViewById<RecyclerView>(R.id.recyclerview)
        recycler.apply{
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(context)
            // set the custom adapter to the RecyclerView

            // ArrayList of class ItemViewModel
            val data = ArrayList<String>()


            // This loop will create 5 views
            for (i in 1..5){
                data.add("")
            }

            adapter = CreationCategorieChampsRVAdapter(data)

//            if (notes != null)
//                adapter = NoteRVAdapter(notes)
        }

        // TODO bouton sauvegarder (creer la categorie dans le realm. Retour au MainActivity)

        // TODO ajouter un champ au recyclerview quand on clique sur un bouton



        // TODO spinner pour dropdown qui permet de choisir entre champ texte et checkbox
        // pour le type de reponse



        // TODO premier champ est le titre de la categorie, et le format est un peu different
        // des autres du recycler view



        // TODO checkbox estObligatoire

//        val spinner: Spinner = findViewById(R.id.type_reponse_spinner)
//
//        // create an ArrayAdapter using the string array and a default spinner layout
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.type_reponse,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
    }
}