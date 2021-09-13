package com.example.daggerhilt.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.R
import com.example.daggerhilt.data.Restaurant
import com.example.daggerhilt.databinding.ActivityRestaurantBinding
import com.example.daggerhilt.showToast
import com.example.daggerhilt.viewModel.PlaceHolderViewModel
import com.hunger.worries.adapters.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity(), GenericAdapter.OnItemClickListener<Any> {
    private val viewModel: PlaceHolderViewModel by viewModels()

    private lateinit var binding: ActivityRestaurantBinding
    private lateinit var restaurantAdapter: GenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchPlaceHolder()
    }

    private fun fetchPlaceHolder() {
        viewModel.getRestaurant()
        viewModel.restaurant.observe(this) {
            setRestaurantAdapter(it)

        }
    }

    private fun setRestaurantAdapter(restaurantList: ArrayList<Restaurant>) {
        restaurantAdapter = GenericAdapter(
            restaurantList as java.util.ArrayList<Any>,
            this,
            R.layout.row_placeholder
        )
        binding.rvPlaceHolder.apply {
            layoutManager = LinearLayoutManager(this@RestaurantActivity)
            adapter = restaurantAdapter
        }

    }

    override fun onItemClick(view: View?, position: Int, `object`: Any) {

    }
}