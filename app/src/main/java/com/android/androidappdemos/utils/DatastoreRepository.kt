package com.android.androidappdemos.utils

import android.content.Context
import android.util.Log
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class DatastoreRepository(context: Context) {
    private val DATASTORE_NAME = "setting"
    var dataStore: DataStore<Preferences> = context.createDataStore(
        DATASTORE_NAME
    )

    private object PreferenceKey {
        val username = preferencesKey<String>("my_name")
    }

    suspend fun putDataIntoStore(name: String) {
        dataStore.edit  { preference->
            preference[PreferenceKey.username] = name
        }
    }

    val readFromDataStore: Flow<String> = dataStore.data
        .catch { exception ->
            if(exception is IOException){
                Log.d("DataStore", exception.message.toString())
                emit(emptyPreferences())
            }else {
                throw exception
            }
        }
        .map { preference ->
            val myName = preference[PreferenceKey.username] ?: "none"
            myName
        }
}

