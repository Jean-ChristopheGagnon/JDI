package com.example.jdi.model

import io.realm.RealmDictionary
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import org.bson.types.ObjectId

open class Note(): RealmObject() {
    @PrimaryKey
    @RealmField("_id") var id: ObjectId = ObjectId()
    var titreNote: String? = null
    var categorie: String? = null
    var reponses: RealmList<Couple>? = null
}
