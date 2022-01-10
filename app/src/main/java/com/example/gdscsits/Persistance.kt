package com.example.gdscsits

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class Persistance {
    companion object{
        @SuppressLint("PrivateApi")
        private fun getContext(): Context {
            val m = Class.forName("android.app.AppGlobals").getMethod("getInitialApplication")
            val application: Application = m.invoke(null) as Application
            return application.applicationContext
        }

        private val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext())

        @JvmStatic
        fun getBool(key: String): Boolean{
            return pref.getBoolean(key, false)
        }

        @JvmStatic
        fun setBool(key: String, value: Boolean): Unit{
            pref.edit().putBoolean(key, value).apply()
        }

        @JvmStatic
        fun getString(key: String): String{
            return pref.getString(key, "")!!
        }

        @JvmStatic
        fun setString(key: String, value: String): Unit{
            pref.edit().putString(key, value).apply()
        }
    }
}