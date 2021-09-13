package com.example.daggerhilt.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.apiService.CannabisApi
import com.example.daggerhilt.data.PlaceHolder
import com.example.daggerhilt.data.Restaurant
import com.example.daggerhilt.util.NetworkBoundResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaceHolderViewModel @Inject constructor(private val cannabisApi: CannabisApi) : ViewModel() {

    private val placeHolderLiveData = MutableLiveData<ArrayList<PlaceHolder>>()
    val placeholder: LiveData<ArrayList<PlaceHolder>> = placeHolderLiveData

    private val restaurantLiveData = MutableLiveData<ArrayList<Restaurant>>()
    val restaurant: LiveData<ArrayList<Restaurant>> = restaurantLiveData

    fun getPlaceHolder() {
        viewModelScope.launch {
            placeHolderLiveData.value = cannabisApi.getPlaceHolder()
        }
    }

    fun getRestaurant() {
        viewModelScope.launch {
            restaurantLiveData.value = cannabisApi.getRestaurant()
        }
    }

}