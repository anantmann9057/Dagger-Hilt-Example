package com.example.daggerhilt.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.R
import com.example.daggerhilt.data.Cannabis
import com.example.daggerhilt.databinding.ActivityMainBinding
import com.example.daggerhilt.viewModel.ViewModel
import com.hunger.worries.adapters.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GenericAdapter.OnItemClickListener<Any> {
    lateinit var cannabisAdapter: GenericAdapter

    private val mViewModel: ViewModel by viewModels()

    lateinit var binding: ActivityMainBinding
    lateinit var cannabisList: ArrayList<Cannabis>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setCannabisAdapter()
        fetchCannabis()

        binding.btFetch.setOnClickListener {
            fetchCannabisBySize(100)
        }
    }

    private fun fetchCannabisBySize(size: Int) {
        mViewModel.fetchCannabisBySize(size)
        mViewModel.cannabisAmount.observe(this) {
            cannabisList = it
            cannabisAdapter.notifyAdapter(cannabisList as java.util.ArrayList<Any>)
        }

    }

    private fun fetchCannabis() {
        mViewModel.fetchCannabisData()
        mViewModel.cannabis.observe(this) {
            cannabisList = it
            cannabisAdapter.notifyAdapter(cannabisList as java.util.ArrayList<Any>)
        }
    }

    private fun setCannabisAdapter() {
        cannabisList = ArrayList()

        cannabisAdapter =
            GenericAdapter(cannabisList as ArrayList<Any>, this, R.layout.row_base)
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = cannabisAdapter
        }
    }

    override
    fun onItemClick(view: View?, position: Int, `object`: Any) {
        when (`object`) {
            is Cannabis -> {
                startActivity(Intent(this, RestaurantActivity::class.java))
            }
        }
    }
}