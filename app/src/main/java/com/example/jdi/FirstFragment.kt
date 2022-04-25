package com.example.jdi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.jdi.model.Note

class FirstFragment() : Fragment() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<NoteRVAdapter.ViewHolder>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // inflate the layout
        val view: View = inflater!!.inflate(R.layout.fragment_first, container, false)
//        parentFragmentManager.beginTransaction().replace(R.id.note_container, NotesFragment(), "tagNotesFragment").commit()

        return view
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?){
        super.onViewCreated(itemView, savedInstanceState)
        val recycler = requireView().findViewById<RecyclerView>(R.id.recyclerview)
        recycler.apply{
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView

            // ArrayList of class ItemViewModel
            val data = ArrayList<Note>()
            val notes = (activity as MainActivity?)!!.queryNotesFromDBM()

            // This loop will create 20 views containing the image with the count of view
//            for (i in 1..20){
//                data.add("Item " + i))
//            }
            if (notes != null)
                adapter = NoteRVAdapter(notes)
        }
    }
}



//setContentView(R.layout.activity_main)
//// getting the recycler view by its id
//val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
//
//// creating a vertical layout manager
//recyclerview.layoutManager = LinearLayoutManager(this)
//
//// ArrayList of class ItemViewModel
//val data = ArrayList<ItemViewModel>()
//
//// This loop will create 20 views containing the image with the count of view
//for (i in 1..20){
//    data.add(ItemViewModel(R.drawable.ic_launcher_foreground, "Item " + i))
//}