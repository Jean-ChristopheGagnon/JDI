package com.example.jdi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jdi.model.Champ
import io.realm.RealmList

class CreerCategorieActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<CreationCategorieChampsRVAdapter.ViewHolder>? = null
    val data = ArrayList<String>()

    var test = CreationCategorieChampsRVAdapter(ArrayList<String>())

    fun saveCategory(view: View){
//        println(test.mDataset)
        val champsRemplis = test.getTempDataset()
        val titre = findViewById<EditText>(R.id.titre_categorie).text.toString()

        val realmList = RealmList<Champ>()

        for(nomChamp in champsRemplis!!){
            val champ = Champ()
            champ.estObligatoire = true
            champ.typeReponse = "Champ texte"
            champ.nomChamp = nomChamp

            realmList.add(champ)
        }

            DataBaseManager().sauverCategorie(titre, realmList)
    }

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



            // This loop will create 5 views
            for (i in 1..5){
                data.add("")
            }
            test = CreationCategorieChampsRVAdapter(data)
            adapter = CreationCategorieChampsRVAdapter(data)


//            if (notes != null)
//                adapter = NoteRVAdapter(notes)
        }






        // adapter.notifyItemChanged(position)


        // TODO ajouter un champ au recyclerview quand on clique sur un bouton
        // data.add("")
        // adapter.notifyItemInserted(data.size() - 1)
        // rvContacts.scrollToPosition(adapter.getItemCount() - 1)








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