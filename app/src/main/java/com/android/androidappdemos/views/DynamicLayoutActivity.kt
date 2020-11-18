package com.android.androidappdemos.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.view.get
import androidx.recyclerview.widget.ItemTouchHelper
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
    private lateinit var foodItemAdapter: FoodItemAdapter
    private val foodItemList = ArrayList<ItemRequestRow>()
    private val itemTocuhHelperCallback =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                TODO("Not yet implemented")
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                foodItemList.removeAt(viewHolder.adapterPosition)
                foodItemAdapter.notifyDataSetChanged()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dynamic_layout)
        initRecyclerview()
        setupItemTouchHelper()
    }

    private fun initRecyclerview() {
        foodItemRecyclerView = recyclerview_food_items
        foodItemList.add(ItemRequestRow(R.id.image_radio_button, EditText(this), Spinner(this)))
        foodItemAdapter = FoodItemAdapter(foodItemList)
        foodItemRecyclerView.adapter = foodItemAdapter
        foodItemRecyclerView.layoutManager = LinearLayoutManager(this)
        ItemTouchHelper(itemTocuhHelperCallback).attachToRecyclerView(foodItemRecyclerView)
    }

    private fun setupItemTouchHelper() {
    }

    override fun addFoodItem() {
        insertItem(foodItemList.size)
    }

    private fun insertItem(position: Int) {
        foodItemList.add(
            position,
            ItemRequestRow(R.id.image_radio_button, EditText(this), Spinner(this))
        )
        foodItemAdapter.notifyItemInserted(position)
    }
}