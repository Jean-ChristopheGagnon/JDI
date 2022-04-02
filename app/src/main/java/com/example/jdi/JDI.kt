package com.example.jdi

import android.app.Application
import io.realm.Realm

class JDI : Application() {
    override fun onCreate(){
        super.onCreate()
        Realm.init(this)
    }

}