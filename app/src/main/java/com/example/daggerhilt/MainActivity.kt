package com.example.daggerhilt

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.databinding.ActivityMainBinding
import com.example.daggerhilt.viewModel.CannabisViewModel
import com.hunger.worries.adapters.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), GenericAdapter.OnItemClickListener<Any> {
    lateinit var homeAdapter: GenericAdapter
    val viewModel: CannabisViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchCannabisData()
        viewModel.cannabis.observe(this) {

            homeAdapter = GenericAdapter(it as ArrayList<Any>, this, R.layout.row_base)
            binding.rvHome.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = homeAdapter
            }
        }

        binding.btFetch.setOnClickListener {
            viewModel.fetchCannabis(100)
            viewModel.cannabisAmount.observe(this) {
                homeAdapter = GenericAdapter(it as ArrayList<Any>, this, R.layout.row_base)
                binding.rvHome.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = homeAdapter
                }
                homeAdapter.notifyAdapter(it as ArrayList<Any>)
            }
        }
    }

    override fun onItemClick(view: View?, position: Int, `object`: Any) {
    }
}