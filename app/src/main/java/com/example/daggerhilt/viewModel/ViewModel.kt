package com.example.daggerhilt.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.apiService.ApiInterface
import com.example.daggerhilt.data.Cannabis
import com.example.daggerhilt.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val apiInterface: ApiInterface,
) : ViewModel() {
    private val cannabisLiveData = MutableLiveData<ArrayList<Cannabis>>()
    val cannabis: LiveData<ArrayList<Cannabis>> = cannabisLiveData

    private val cannabisBySizeLiveData = MutableLiveData<ArrayList<Cannabis>>()
    val cannabisAmount: LiveData<ArrayList<Cannabis>> = cannabisBySizeLiveData

    private val restaurantLiveData = MutableLiveData<ArrayList<Restaurant>>()
    val restaurant: LiveData<ArrayList<Restaurant>> = restaurantLiveData

    fun fetchCannabisBySize(size: Int) {
        viewModelScope.launch {
            cannabisBySizeLiveData.value = apiInterface.getCannabisWithSize(size)
        }
    }

    fun fetchCannabisData() {
        viewModelScope.launch {
            cannabisLiveData.value = apiInterface.getCannabis()
        }
    }

    fun getRestaurant() {
        viewModelScope.launch {
            restaurantLiveData.value = apiInterface.getRestaurant()
        }
    }

}