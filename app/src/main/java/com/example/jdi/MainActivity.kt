package com.example.jdi


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.jdi.model.Couple
import com.example.jdi.model.Note
import com.google.android.material.tabs.TabLayout
import io.realm.RealmList
import io.realm.RealmResults


class MainActivity : AppCompatActivity() {

    private lateinit var pager: ViewPager // creating object of ViewPager
    private lateinit var tab: TabLayout  // creating object of TabLayout
    private lateinit var bar: Toolbar    // creating object of ToolBar
    var dataBaseManager : DataBaseManager = DataBaseManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // set the references of the declared objects above
        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)

        // To make our toolbar show the application
        // we need to give it to the ActionBar
        setSupportActionBar(bar)

        // Initializing the ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager)

        // add fragment to the list
        adapter.addFragment(FirstFragment(), "Notes quotidiennes")
        adapter.addFragment(SecondFragment(), "Nouvelle note")

        // Adding the Adapter to the ViewPager
        pager.adapter = adapter

        // bind the viewPager with the TabLayout.
        tab.setupWithViewPager(pager)

    }

    fun passListToDBM(listeCouple : RealmList<Couple>, titreNote : String, categorieID : String) {
        dataBaseManager.sauverNote(listeCouple, titreNote, categorieID)
    }

    fun queryNotesFromDBM(): RealmResults<Note>? {
        return dataBaseManager.chargerNotes()
    }

    fun refreshNotes(){
        var frg: Fragment? = supportFragmentManager.findFragmentByTag("tagNotesFragment")

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (frg != null) {
            ft.detach(frg)
        }
        ft.commit()

        val ft2: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (frg != null) {
            ft2.attach(frg)
        }
        ft2.commit()


    }


}