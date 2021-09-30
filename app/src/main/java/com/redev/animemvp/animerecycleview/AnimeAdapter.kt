package com.redev.animemvp.animerecycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.redev.animemvp.CRUDDialog
import com.redev.animemvp.R
import com.redev.animemvp.models.Anime
import com.redev.animemvp.presenter.AnimePresenter

class AnimeAdapter : RecyclerView.Adapter<AnimeHolder>() {
    //
    private  var items:List<Anime>? = null
    private var fragmentManager:FragmentManager? = null
    private lateinit var animePresenter: AnimePresenter
    fun updateItems(items:List<Anime>)
    {
        this.items = null
        this.items = items
    }
    fun manager(fragmentManager:FragmentManager,animePresenter: AnimePresenter)
    {
        this.fragmentManager = fragmentManager
        this.animePresenter = animePresenter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_item_layout , parent , false)

        return  AnimeHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
      val anime = items?.get(position)
        if(anime != null)
        {
            holder.txtName.text = anime.Name
            holder.txtPrice.text = anime.Price?: "jaspdpoas"

            holder.txtPrice.setOnClickListener {
                CRUDDialog.newInstance(animePresenter,anime).show(fragmentManager!!,null)
            }
        }

    }

    override fun getItemCount(): Int {
      return items?.size ?: 0
    }
}