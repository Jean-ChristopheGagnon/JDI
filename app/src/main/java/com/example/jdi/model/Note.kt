package com.example.jdi.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import org.bson.types.ObjectId

open class Note(): RealmObject() {
    @PrimaryKey
    @RealmField("_id") var id: ObjectId = ObjectId()
    var titreNote: String? = null
    var categorie: Categorie? = null
    var reponses: Map<Champ, String>? = null
}