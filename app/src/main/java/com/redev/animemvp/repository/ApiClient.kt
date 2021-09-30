package com.redev.animemvp.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    private  var retrofit: Retrofit? = null

    fun newInstance():AnimePrepositoryBase
    {
        if(retrofit == null)
    {
        retrofit = Retrofit.Builder().baseUrl("http://10.99.4.119:3000/redev/api/anime/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
        return retrofit!!.create(AnimePrepositoryBase::class.java)
    }

}