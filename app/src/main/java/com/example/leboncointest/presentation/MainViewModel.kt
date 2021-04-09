package com.example.leboncointest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leboncointest.domain.GetSongsUseCase
import com.example.leboncointest.domain.SongsElements
import kotlinx.coroutines.launch

class MainViewModel(
    private val getSongsUseCase: GetSongsUseCase
) : ViewModel() {

    private val _liveDataSongs: MutableLiveData<List<SongsElements>> = MutableLiveData()
    val liveDataSongs: LiveData<List<SongsElements>> get() = _liveDataSongs

    init {
        viewModelScope.launch {
            val jsonResult = getSongsUseCase.invoke()

            _liveDataSongs.value = jsonResult.elements.filter {
                it.titre != null
            }
        }
    }
}