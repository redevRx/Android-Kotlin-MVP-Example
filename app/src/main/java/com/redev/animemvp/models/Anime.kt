package com.redev.animemvp.models

import com.google.gson.annotations.SerializedName

class Anime {

    @SerializedName("id")
    private var id:Int? = null

    @SerializedName("name")
    private var name:String? = null

    @SerializedName("descript")
    private var descript:String? = null

    @SerializedName("rating")
    private var rating:String? = null

    @SerializedName("price")
    private var price:String? = null

    @SerializedName("url")
    private var url:String? = null

    var Id:Int?
            get() = id
    set(value) {
        id = value
    }

    var Name:String?
    get() = name
    set(value) {name = value}

    var Descrip:String?
    get() = descript
    set(value) {descript = value}

    var Rating:String?
    get() = rating
    set(value) {rating = value}

    var Price:String?
    get() = price
    set(value) {price = value}

    var Url:String?
    get() = url
    set(value) {url = value}


    fun toMap():MutableMap<String,Any>
    {
        val map:MutableMap<String,Any> = mutableMapOf()

        map.put("${name}", name?:"")
        map.put("${descript}" , descript?:"")
        map.put("${rating}",rating?:"")
        map.put("${price}",price?:"")
        map.put("${url}",url?:"")
        return map
    }
}