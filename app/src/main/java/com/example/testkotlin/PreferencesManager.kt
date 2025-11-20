package com.example.testkotlin
import android.content.Context

class PreferencesManager(private val context: Context) {

    private val sharedPreferences = context.getSharedPreferences(
        "app_preferences", Context.MODE_PRIVATE
    )

    fun saveUserName(name: String) {
        sharedPreferences.edit().putString("user_name", name).apply()
    }

    fun getUserName(): String? {
        return sharedPreferences.getString("user_name", null)
    }

    companion object
}