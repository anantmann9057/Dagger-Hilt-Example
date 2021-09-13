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
    private val cannabisAmountLiveData = MutableLiveData<ArrayList<Cannabis>>()
    val cannabisAmount: LiveData<ArrayList<Cannabis>> = cannabisAmountLiveData

    fun fetchCannabis(size: Int) {
        viewModelScope.launch {
            val cannabisAmount = cannabisApi.getCannabisWithSize(size)
            cannabisAmountLiveData.value = cannabisAmount
        }
    }

    fun fetchCannabisData(){
        viewModelScope.launch {
            val cannabis = cannabisApi.getCannabis()
            cannabisLiveData.value = cannabis
        }
    }



}