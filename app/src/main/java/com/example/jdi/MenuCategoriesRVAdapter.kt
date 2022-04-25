package com.example.jdi

import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView
import com.example.jdi.model.Categorie
import io.realm.RealmResults

class MenuCategoriesRVAdapter(private val mList: RealmResults<Categorie>) : RecyclerView.Adapter<MenuCategoriesRVAdapter.ViewHolder>() {


    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_cell_category, parent, false)


        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val categorie = mList[position]

        holder.textView.text = categorie!!.nomCategorie

    }

    // return the number of the items in the list
    override fun getItemCount(): Int{
        return mList.size
    }

    // Holds the views for adding it to text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        var textView: TextView = itemView.findViewById(R.id.titre_categorie)



    }
}