package com.example.jdi.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import io.realm.annotations.Required
import org.bson.types.ObjectId
import java.lang.IllegalArgumentException

open class Champ(): RealmObject() {
    @PrimaryKey
    @RealmField("_id") var id: ObjectId = ObjectId()
    @Required
    var nomChamp: String = ""
    @Required
    var typeReponse: String = TypeReponse.Texte.name
    @Required
    var estObligatoire: Boolean = true
    var typeReponseEnum: TypeReponse
        get() {
            return try {
                TypeReponse.valueOf(typeReponse)
            } catch (e: IllegalArgumentException){
                TypeReponse.Texte
            }
        }
        set(value){ typeReponse = value.name }
}