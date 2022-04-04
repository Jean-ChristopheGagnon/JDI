package com.example.jdi.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmField
import io.realm.annotations.Required
import org.bson.types.ObjectId
import java.lang.IllegalArgumentException
import java.util.*

open class Couple(inputChamp : Champ? = null, inputTexte : String? = null, inputBool : Boolean? = null, inputInt : Int? = null, inputDate : Date? = null, inputDouble : Double? = null): RealmObject() {
    var champ : Champ? = inputChamp
    var texte : String? = inputTexte
    var bool : Boolean? = inputBool
    var int : Int? = inputInt
    var date : Date? = inputDate
    var double : Double? = inputDouble
}
