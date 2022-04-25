package com.example.jdi.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import io.realm.annotations.Required
import org.bson.types.ObjectId
import java.lang.IllegalArgumentException


open class Categorie(): RealmObject() {
    @PrimaryKey @RealmField("_id") var id: ObjectId = ObjectId()
    var nomCategorie: String? = null
    var frequence: String? = null
    var listeChamps: RealmList<Champ> = RealmList()

    @Required
    var typeCategorie: String = TypeCategorie.Spontanee.name
    var typeCategorieEnum : TypeCategorie

        get() {
            return try {
                TypeCategorie.valueOf(typeCategorie)
            } catch (e: IllegalArgumentException){
                TypeCategorie.Spontanee
            }
        }
    set(value){ typeCategorie = value.name }
}
