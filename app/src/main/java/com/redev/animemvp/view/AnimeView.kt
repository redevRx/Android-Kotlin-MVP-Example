package com.redev.animemvp.view

import com.redev.animemvp.models.Anime

interface AnimeView
{
    fun onLoadedAnime(anime:List<Anime>)
    fun onLoadingAnime()
    fun showProgress()
}