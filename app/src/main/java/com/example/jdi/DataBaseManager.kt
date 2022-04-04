package com.example.jdi

import android.app.Application
import com.example.jdi.model.*
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmList
import io.realm.RealmResults
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.bson.types.ObjectId



class DataBaseManager : Application() {

    var backgroundThreadRealm : Realm = Realm.getDefaultInstance()

    override fun onCreate(){
        super.onCreate()
        Realm.init(this)


        // Si on enlève les commentaires du code suivant:
        // ca cree une categorie Films avec quatre champs dont un
        // optionnel dans un fichier realm qui est cree dans l'emulateur
        // ou dans l'appareil au moment ou on lance l'application.
        // On peut trouver ce fichier Realm dans
        // data/data/com.example.jdi/files/My Project

        // On peut ouvrir les fichiers Realm avec MongoDB Realm Studio
        // (pour les visualiser)


        val realmName: String = "projectJDI"
        val config = RealmConfiguration.Builder().name(realmName).build()
        backgroundThreadRealm = Realm.getInstance(config)

        val query = backgroundThreadRealm.where<Categorie>()
        if(query.equalTo("nomCategorie", getString(R.string.film)).count() == 0.toLong()){
            sauverCatFilms(backgroundThreadRealm)
        }
        if(query.equalTo("nomCategorie", getString(R.string.reve)).count() == 0.toLong()){
            sauverCatReve(backgroundThreadRealm)
        }
        if(query.equalTo("nomCategorie", getString(R.string.texte)).count() == 0.toLong()){
            sauverCatTexte(backgroundThreadRealm)
        }
    }

    fun sauverCatFilms(backgroundThreadRealm : Realm){
        val transaction = backgroundThreadRealm.executeTransactionAsync { transactionRealm ->
            var categorie = transactionRealm.createObject<Categorie>("2")
            categorie.nomCategorie = getString(R.string.film)
            categorie.frequence = "daily"
            categorie.typeCategorie = "Récurrente"
            var champ1 = Champ()
            champ1.nomChamp = "Titre"
            champ1.estObligatoire = true
            champ1.typeReponse = "Champ texte"
            var champ2 = Champ()
            champ2.nomChamp = "Commentaire"
            champ2.estObligatoire = false
            champ2.typeReponse = "Champ texte"
            var champ3 = Champ()
            champ3.nomChamp = "Deja vu?"
            champ3.estObligatoire = true
            champ3.typeReponse = "Checkbox"
            var champ4 = Champ()
            champ4.nomChamp = "Cinema?"
            champ4.estObligatoire = true
            champ4.typeReponse = "Checkbox"
            categorie.listeChamps = RealmList()
            categorie.listeChamps.add(champ1)
            categorie.listeChamps.add(champ2)
            categorie.listeChamps.add(champ3)
            categorie.listeChamps.add(champ4)
        }
    }

    fun sauverCatReve(backgroundThreadRealm: Realm) {
        val transaction = backgroundThreadRealm.executeTransactionAsync { transactionRealm ->
            var categorie = transactionRealm.createObject<Categorie>("1")
            categorie.nomCategorie = getString(R.string.reve)
            categorie.frequence = "daily"
            categorie.typeCategorie = "Récurrente"
            var champ1 = Champ()
            champ1.nomChamp = "Commentaire"
            champ1.estObligatoire = true
            champ1.typeReponse = "Champ texte"
            var champ2 = Champ()
            champ2.nomChamp = "Date"
            champ2.estObligatoire = false
            champ2.typeReponse = "Date"
            categorie.listeChamps = RealmList()
            categorie.listeChamps.add(champ1)
            categorie.listeChamps.add(champ2)
        }
    }

    fun sauverCatTexte(backgroundThreadRealm: Realm){
        val transaction = backgroundThreadRealm.executeTransactionAsync { transactionRealm ->
            var categorie = transactionRealm.createObject<Categorie>("0")
            categorie.nomCategorie = getString(R.string.texte)
            categorie.frequence = "daily"
            categorie.typeCategorie = "Récurrente"
            var champ1 = Champ()
            champ1.nomChamp = "Note textuelle"
            champ1.estObligatoire = true
            champ1.typeReponse = "Champ texte"
            categorie.listeChamps = RealmList()
            categorie.listeChamps.add(champ1)
        }
    }

    fun sauverNote(listeCouple : RealmList<Couple>, inputTitreNote : String, inputCategorieID : String){

        val transaction = backgroundThreadRealm.executeTransactionAsync { transactionRealm ->
            var note : Note = transactionRealm.createObject<Note>(ObjectId())
            note.reponses?.addAll(listeCouple)
            note.titreNote = inputTitreNote
            note.categorie = inputCategorieID
        }


    }

    fun chargerNotes(): RealmResults<Note>? {
        val query = backgroundThreadRealm.where<Note>()
        return query.findAll()
    }


}