package com.example.MoviesList.tool

import android.content.Context

class Pref (val context: Context?) {
    val SHARE_BDNAME = "dateUpdateBD"
    val SHARE_ID = "Id"
    val SHARE_DATE = "date"

    val store = context!!.getSharedPreferences(SHARE_BDNAME, 0)

    fun saveId(id: String){
        store.edit().putString(SHARE_ID, id).apply()
    }
    fun saveDate(name: String){
        store.edit().putString(SHARE_DATE, name).apply()
    }
    fun getId():String{
        return store.getString(SHARE_ID, "")!!
    }
    fun getDate():String{
        return store.getString(SHARE_DATE, "")!!
    }

    fun deleteSession(){
        store.edit().clear().apply()
    }
}