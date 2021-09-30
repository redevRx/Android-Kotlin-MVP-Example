package com.redev.animemvp.presenter

import com.redev.animemvp.models.Anime

interface AnimePresenter
{
    fun onSaveAnime(anime:Anime)
    fun onUpdateAnime(anime:Anime)
    fun onRemoveAnime(id:Anime)
    fun getAnimes()
}