package com.example.practicaltestmovie.Repository

import android.content.Context
import androidx.core.content.edit

class PreferencesManager(context: Context) {
    private val sharedPref = context.getSharedPreferences("login_prefs", Context.MODE_PRIVATE)

    fun saveCredentials(email: String, password: String) {
        sharedPref.edit {
            putString("email", email)
            putString("password", password)
        }
    }

    fun getCredentials(): Pair<String?, String?> {
        return Pair(
            sharedPref.getString("email", null),
            sharedPref.getString("password", null)
        )
    }

    fun clearCredentials() {
        sharedPref.edit {
            remove("email")
            remove("password")
        }
    }
}