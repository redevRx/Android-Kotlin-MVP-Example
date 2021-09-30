package com.redev.animemvp.animerecycleview

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.redev.animemvp.R

class AnimeHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var txtName:TextView
    var txtPrice:TextView
    var imageAnime:ImageView

    init {
        txtName = itemView.findViewById(R.id.txtItemName)
        txtPrice = itemView.findViewById(R.id.txtItemPrice)
        imageAnime = itemView.findViewById(R.id.imageItemAnime)
    }
}