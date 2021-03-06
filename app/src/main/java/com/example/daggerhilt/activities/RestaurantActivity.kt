package com.example.daggerhilt.activities

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.R
import com.example.daggerhilt.data.Restaurant
import com.example.daggerhilt.databinding.ActivityRestaurantBinding
import com.example.daggerhilt.module.SampleMethods
import com.example.daggerhilt.viewModel.AnotherViewModel
import com.example.daggerhilt.viewModel.ViewModel
import com.hunger.worries.adapters.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity(), GenericAdapter.OnItemClickListener<Any> {
    @Inject
    lateinit var sampleMethods: SampleMethods

    private val mViewModel: ViewModel by viewModels()
    private val anotherViewModel: AnotherViewModel by viewModels()
    private lateinit var binding: ActivityRestaurantBinding
    private lateinit var restaurantAdapter: GenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sampleMethods.showToast(this, "this is injected")
        fetchPlaceHolder()
    }

    private fun fetchPlaceHolder() {
        anotherViewModel.getRestaurant()
        anotherViewModel.restaurant.observe(this) {
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