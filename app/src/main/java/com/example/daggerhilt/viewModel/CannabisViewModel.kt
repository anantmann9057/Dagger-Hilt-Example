package com.example.daggerhilt.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.apiService.CannabisApi
import com.example.daggerhilt.data.Cannabis
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CannabisViewModel @Inject constructor(private val cannabisApi: CannabisApi) : ViewModel() {
    private val cannabisLiveData = MutableLiveData<ArrayList<Cannabis>>()
    val cannabis: LiveData<ArrayList<Cannabis>> = cannabisLiveData
    private val cannabisBySizeLiveData = MutableLiveData<ArrayList<Cannabis>>()
    val cannabisAmount: LiveData<ArrayList<Cannabis>> = cannabisBySizeLiveData

    fun fetchCannabisBySize(size: Int) {
        viewModelScope.launch {
            cannabisBySizeLiveData.value = cannabisApi.getCannabisWithSize(size)
        }
    }

    fun fetchCannabisData() {
        viewModelScope.launch {
            cannabisLiveData.value = cannabisApi.getCannabis()
        }
    }


}