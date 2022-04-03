package com.example.jdi

import android.app.Application
import com.example.jdi.model.Categorie
import com.example.jdi.model.Champ
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmList
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import org.bson.types.ObjectId

class DataBaseManager : Application() {
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
        val backgroundThreadRealm: Realm = Realm.getInstance(config)

        val query = backgroundThreadRealm.where<Categorie>()
        if(query.equalTo("nomCategorie", "Films").count() == 0.toLong()){
            sauverCatFilms(backgroundThreadRealm)
        }
        if(query.equalTo("nomCategorie", "Reves").count() == 0.toLong()){
            sauverCatReve(backgroundThreadRealm)
        }
        if(query.equalTo("nomCategorie", "Texte").count() == 0.toLong()){
            sauverCatReve(backgroundThreadRealm)
        }
    }

    fun sauverCatFilms(backgroundThreadRealm : Realm){
        val transaction = backgroundThreadRealm.executeTransactionAsync { transactionRealm ->
            var categorie = transactionRealm.createObject<Categorie>(ObjectId())
            categorie.nomCategorie = "Films"
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
        //TODO
    }

    fun sauverCatTexte(backgroundThreadRealm: Realm){
        //TODO
    }
}