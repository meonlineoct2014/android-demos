package com.android.androidappdemos.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.android.androidappdemos.R
import com.android.androidappdemos.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val factory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        mainViewModel = ViewModelProvider(this, factory)
            .get(MainViewModel::class.java)

        mainViewModel.readFromStore.observe(
            this
        ) { myName ->
            textView.text = myName
        }
        button_save_data_in_datastore.setOnClickListener {
            mainViewModel.saveDataIntoDataStore(editTextTextPersonName.text.toString())
        }
    }
}
