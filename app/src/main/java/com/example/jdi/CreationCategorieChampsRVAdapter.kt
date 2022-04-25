package com.example.jdi

import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.TextView

class CreationCategorieChampsRVAdapter(private val mList: ArrayList<String>) : RecyclerView.Adapter<CreationCategorieChampsRVAdapter.ViewHolder>() {

    var mDataset: ArrayList<String>? = mList

    fun getTempDataset() : ArrayList<String>?{
        return mDataset
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_category_design, parent, false)


        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val string = mList[position]

        // sets the text to the textview from our itemHolder class
        holder.textView.text = string
//        holder.textView.setTag(holder.bindingAdapterPosition)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int{
        return mList.size
    }

    // Holds the views for adding it to text
    inner class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){
        var textView: TextView = itemView.findViewById(R.id.textView)


        init {

            textView.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable) {
//                    println(textView.getTag())
                    // TODO after text changed recycler view notify update
                }

                override fun beforeTextChanged(
                    s: CharSequence, start: Int,
                    count: Int, after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence, start: Int,
                    before: Int, count: Int
                ) {
                    mDataset!!.set(bindingAdapterPosition,s.toString())

//                    println(mDataset)

                }
            })
        }


    }
}