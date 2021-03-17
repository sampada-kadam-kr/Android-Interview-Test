package com.kroger.androidinterview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ComicViewModel @Inject constructor(private val comicRepository: ComicRepository) :
    ViewModel() {

    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            comicRepository.getCurrentComic()
        }

    }

}