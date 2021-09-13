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
class CannabisViewModel @Inject constructor(cannabisApi: CannabisApi) : ViewModel() {
    private val cannabisLiveData = MutableLiveData<ArrayList<Cannabis>>()
    val cannabis: LiveData<ArrayList<Cannabis>> = cannabisLiveData

    init {
        viewModelScope.launch {
            val cannabis = cannabisApi.getCannabisWithSize(50)

            cannabisLiveData.value = cannabis
        }
    }
}