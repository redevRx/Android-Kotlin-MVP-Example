package com.redev.animemvp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.redev.animemvp.animerecycleview.AnimeAdapter
import com.redev.animemvp.databinding.FragmentHomeBinding
import com.redev.animemvp.models.Anime
import com.redev.animemvp.presenter.AnimePresenter
import com.redev.animemvp.presenter.AnimePresenterMain
import com.redev.animemvp.view.AnimeView
import com.redev.animemvp.viewModel.AnimeViewModel


class HomeFragment : Fragment() , AnimeView{

    companion object{
       private lateinit var fragmentSupport:FragmentManager
        fun newInstance(fragmentManager:FragmentManager):Fragment
        {
            var home = HomeFragment()
            this.fragmentSupport = fragmentManager
            return home
        }
    }

    private lateinit var binding:FragmentHomeBinding
    //anime presenter
    private lateinit var animePresenter: AnimePresenter
    //dialog crud

    //adapter
    private lateinit var animeAdapter:AnimeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        animePresenter = AnimePresenterMain(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root

        animeAdapter = AnimeAdapter()
        animeAdapter.manager(fragmentSupport , animePresenter)
        binding.recycleViewAnime.adapter = animeAdapter
        binding.recycleViewAnime.layoutManager = LinearLayoutManager(view.context)
        binding.recycleViewAnime.hasFixedSize()
        binding.recycleViewAnime.addItemDecoration(DividerItemDecoration(view.context , DividerItemDecoration.VERTICAL))

        //todo
        showDialog()
        animePresenter.getAnimes()

        //
        return view
    }

    override fun onLoadedAnime(anime: List<Anime>) {


        animeAdapter.updateItems(anime)
        animeAdapter.notifyDataSetChanged()
        Log.d("get animes","Call started")
    }

    override fun onLoadingAnime() {
        //show progress
        Log.d("get animes","Call started loding")
    }

    override fun showProgress() {
        TODO("Not yet implemented")
    }

    fun showDialog()
    {

        binding.btnShowDialog.setOnClickListener {
            Log.d("showDialog","start show dialog crud")
            fragmentSupport?.let { it1 -> CRUDDialog.newInstance(animePresenter , null).show(it1,"") }
        }
    }

}