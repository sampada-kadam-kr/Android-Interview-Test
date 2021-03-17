package com.kroger.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kroger.start.db.Comic
import com.kroger.start.di.Local
import com.kroger.start.di.Remote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ComicViewModel @Inject constructor(
    @Local private val localRepository: ComicRepository,
    @Remote private val remoteRepository: ComicRepository
) : ViewModel() {

    private var _comic = MutableLiveData<Comic>()
    val comic: LiveData<Comic> = _comic


    fun start() {
        viewModelScope.launch {
            val comic = remoteRepository.getCurrentComic()
            _comic.value = comic
        }

    }
}