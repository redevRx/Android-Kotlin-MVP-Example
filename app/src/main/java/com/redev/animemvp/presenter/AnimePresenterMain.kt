package com.redev.animemvp.presenter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.redev.animemvp.models.Anime
import com.redev.animemvp.repository.ApiClient
import com.redev.animemvp.view.AnimeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimePresenterMain : AnimePresenter {
    private  var view:AnimeView
    constructor(view:AnimeView){
        this.view = view
    }

    //live data list anime
    val animeList = MutableLiveData<List<Anime>>()
    //live data anime

    //api client
    private val api = ApiClient().newInstance()

    override fun onSaveAnime(anime: Anime) {
       api.onSaveAnime(anime).enqueue(object :Callback<Anime>{
           override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
              if (response.isSuccessful)
              {
                  Log.d("post anime","post success")
              }
           }

           override fun onFailure(call: Call<Anime>, t: Throwable) {
               Log.e("post anime","save anime error ${t.message}")
           }
       })

        this.getAnimes()
    }

    override fun onUpdateAnime(anime: Anime) {
        TODO("Not yet implemented")
    }

    override fun onRemoveAnime(id: Anime) {
        Log.d("remove anime","post s${id.Id}")
      api.onRemove(id).enqueue(object :Callback<Anime>{
          override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
              if (response.isSuccessful)
              {
                  Log.d("remove anime","post success")
              }
          }

          override fun onFailure(call: Call<Anime>, t: Throwable) {
              Log.e("remove anime","remove anime error ${t.message}")
          }
      })
    }

    override fun getAnimes() {
        //show progess loding wait anime
        view.onLoadingAnime()

        //todo get anime use retrofit redev/api/anime
        api.getAnimes().enqueue(object :Callback<List<Anime>>{
            override fun onResponse(call: Call<List<Anime>>, response: Response<List<Anime>>) {

                animeList.value = response.body()
                animeList.value?.let { view.onLoadedAnime(it) }
            }

            override fun onFailure(call: Call<List<Anime>>, t: Throwable) {
               Log.e("get anime error","${t.message}")
            }
        })
//        show result anime

    }
}