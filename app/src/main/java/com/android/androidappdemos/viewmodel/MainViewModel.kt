package com.android.androidappdemos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.android.androidappdemos.utils.DatastoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = DatastoreRepository(application)
    val readFromStore = repository.readFromDataStore.asLiveData()
    fun saveDataIntoDataStore(input: String) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.putDataIntoStore(input)
        }
}