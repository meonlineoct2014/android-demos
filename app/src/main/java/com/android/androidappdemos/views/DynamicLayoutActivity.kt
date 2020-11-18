package com.android.androidappdemos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.androidappdemos.R
import com.android.androidappdemos.adapters.FoodItemAdapter
import com.android.androidappdemos.interfaces.ItemRequestInterface
import com.android.androidappdemos.models.ItemRequestRow
import kotlinx.android.synthetic.main.activity_dynamic_layout.*
import kotlinx.android.synthetic.main.item_row.*

class DynamicLayoutActivity : AppCompatActivity(), ItemRequestInterface {
    private lateinit var foodItemRecyclerView: RecyclerView
    private lateinit var foodItemLayoutManager: RecyclerView.LayoutManager
    private lateinit var foodItemAdapter: FoodItemAdapter
    private val foodItemList = ArrayList<ItemRequestRow>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dynamic_layout)

        foodItemRecyclerView = recyclerview_food_items
        foodItemLayoutManager = LinearLayoutManager(this)
        var editText = EditText(this)
        editText.hint = "hint 1"
        var spinner1 = Spinner(this)
        foodItemList.add(ItemRequestRow(R.id.image_radio_button, editText, spinner1))
        foodItemAdapter = FoodItemAdapter(foodItemList)
        foodItemRecyclerView.adapter = foodItemAdapter
        foodItemRecyclerView.layoutManager = foodItemLayoutManager
    }

    override fun addFoodItem() {
        insertItem(foodItemList.size)
    }

    private fun insertItem(position: Int) {
        var editText = EditText(this)
        editText.hint = "add more items"
        var spinner1 = Spinner(this)
        foodItemList.add(position, ItemRequestRow(R.id.image_radio_button, editText, spinner1))
        foodItemAdapter.notifyItemInserted(position)
    }
}