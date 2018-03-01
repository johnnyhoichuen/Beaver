package net.samystudio.beaver.data.manager

import android.content.Context
import android.content.SharedPreferences
import net.samystudio.beaver.R
import net.samystudio.beaver.di.qualifier.ApplicationContext
import net.samystudio.beaver.ext.putString

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesManager
@Inject
constructor(@param:ApplicationContext
            private val context: Context,
            private val sharedPreferences: SharedPreferences)
{
    var apiUrl: String
        get() = sharedPreferences.getString(API_URL, context.getString(R.string.api_url))
        set(value) = sharedPreferences.putString(API_URL, value)

    var userToken: String?
        get() = sharedPreferences.getString(USER_TOKEN, null)
        set(value) = sharedPreferences.putString(USER_TOKEN, value)

    companion object
    {
        private const val API_URL = "SharedPreferencesManager:apiUrl"
        private const val USER_TOKEN = "SharedPreferencesManager:userToken"
    }
}
