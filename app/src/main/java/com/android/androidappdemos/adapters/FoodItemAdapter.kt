package com.android.androidappdemos.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.android.androidappdemos.R
import com.android.androidappdemos.models.ItemRequestRow
import com.android.androidappdemos.views.DynamicLayoutActivity

class FoodItemAdapter(private val dataSet: ArrayList<ItemRequestRow>) :
    RecyclerView.Adapter<FoodItemAdapter.ViewHolder>() {

    lateinit var context: Context


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var radioButtonImageView: ImageView = view.findViewById(R.id.image_radio_button)
        var foodItemName: EditText = view.findViewById(R.id.editText_foodname)
        var quantitySpinner: Spinner = view.findViewById(R.id.spinner_quantity_selector)

        var spinnerAdapter = ArrayAdapter.createFromResource(
            view.context, R.array.spinner_quantities,
            android.R.layout.simple_spinner_item
        )
        private val quantitySelector = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (context as DynamicLayoutActivity).addFoodItem()
            }
        }

        init {
            quantitySpinner.adapter = spinnerAdapter
            quantitySpinner.setSelection(Adapter.NO_SELECTION, true)
            quantitySpinner.onItemSelectedListener = quantitySelector
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_row, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        context = viewHolder.radioButtonImageView.context
        var currentItem = dataSet[position]
        viewHolder.foodItemName = currentItem.fruitName
        viewHolder.foodItemName.hint = currentItem.fruitName.hint
        viewHolder.quantitySpinner = currentItem.quanitySelecter
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}
