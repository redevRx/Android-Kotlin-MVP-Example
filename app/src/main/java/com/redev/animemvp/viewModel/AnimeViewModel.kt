package com.redev.animemvp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.redev.animemvp.models.Anime

class AnimeViewModel :ViewModel()
{
    //single anime
    private val animeMutable = MutableLiveData<Anime>()
    val animeSingleListening :LiveData<Anime> get()  = animeMutable

    //list anime
    private val animeMutableList = MutableLiveData<List<Anime>>()
    val animeListListening: LiveData<List<Anime>> get() = animeMutableList

    fun onAnimeChange(aniem:Anime)
    {
        animeMutable.value = aniem
    }

   suspend fun onAnimeChangeIO(anime: Anime)
    {
        animeMutable.postValue(anime)
    }

    fun onAnimesChange(anime: List<Anime>)
    {
        animeMutableList.value = anime;
    }

    suspend fun onAnimesChangeIO(anime:List<Anime>)
    {
        animeMutableList.postValue(anime)
    }
}