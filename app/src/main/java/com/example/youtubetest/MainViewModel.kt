package com.example.youtubetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.youtubetest.apiService.getHtml
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private val _links = MutableSharedFlow<String>()
    val links: SharedFlow<String> = _links

    fun getVideos(query:String){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                getHtml.getVideos(query).collect{
                    _links.emit(it)
                }
            }
        }
    }
}