package com.example.daggerhilt

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daggerhilt.data.PlaceHolder
import com.example.daggerhilt.databinding.ActivityPlaceHolderBinding
import com.example.daggerhilt.viewModel.PlaceHolderViewModel
import com.hunger.worries.adapters.GenericAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlaceHolderActivity : AppCompatActivity(), GenericAdapter.OnItemClickListener<Any> {
    private val viewHolder: PlaceHolderViewModel by viewModels()

    private lateinit var binding: ActivityPlaceHolderBinding
    private lateinit var placeholderAdapter: GenericAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlaceHolderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchPlaceHolder()
    }

    fun fetchPlaceHolder() {
        viewHolder.getPlaceHolder()
        viewHolder.placeholder.observe(this) {
            setPlaceHolderApdater(it)
        }
    }

    fun setPlaceHolderApdater(placeholderList: ArrayList<PlaceHolder>) {
        placeholderAdapter = GenericAdapter(
            placeholderList as java.util.ArrayList<Any>,
            this,
            R.layout.row_placeholder
        )
        binding.rvPlaceHolder.apply {
            layoutManager = LinearLayoutManager(this@PlaceHolderActivity)
            adapter = placeholderAdapter
        }

    }

    override fun onItemClick(view: View?, position: Int, `object`: Any) {

    }
}