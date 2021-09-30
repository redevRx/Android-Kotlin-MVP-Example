package com.redev.animemvp.repository

import com.redev.animemvp.models.Anime
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface AnimePrepositoryBase
{
    @GET("all")
    fun getAnimes():Call<List<Anime>>

    @GET("")
    fun getOneAnime():Call<Anime>

    @GET("all")
    suspend fun getAnimesIO():Call<List<Anime>>

    @POST("new")
    fun onSaveAnime(@Body anime:Anime):Call<Anime>

    @PUT("edit")
    fun onUpdateAnime(@Body anime:Anime)

    @DELETE("remove")
    fun onRemove(@Body anime:Anime):Call<Anime>
}