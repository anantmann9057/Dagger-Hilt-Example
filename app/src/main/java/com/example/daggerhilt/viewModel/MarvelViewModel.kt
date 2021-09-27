package com.example.daggerhilt.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.apiService.MarvelApiService
import com.example.daggerhilt.data.Marvel
import com.example.daggerhilt.data.ResultsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MarvelViewModel @Inject constructor() : ViewModel() {
    var marvelResponse = MutableLiveData<ArrayList<ResultsItem>>()


}