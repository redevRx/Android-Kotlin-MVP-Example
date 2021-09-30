package com.redev.animemvp

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.redev.animemvp.databinding.CrudDialogBinding
import com.redev.animemvp.models.Anime
import com.redev.animemvp.presenter.AnimePresenter
import com.redev.animemvp.presenter.AnimePresenterMain

class CRUDDialog : DialogFragment()
{
    private lateinit var binding:CrudDialogBinding
    //
    //
    companion object{
        private lateinit var animePresenter:AnimePresenter
        private lateinit var data:Anime
        fun newInstance(anime:AnimePresenter , data:Anime?):DialogFragment
        {
            animePresenter = anime
            if (data != null) {
                this.data = data
            }
            return CRUDDialog()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.crud_dialog, container, false)
        binding = CrudDialogBinding.inflate(layoutInflater)
        val view = binding.root

        //todo

        //close this dialog
        closeDialog()


        //btn save anime
        saveAnime()

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
       this.dialog?.show()
    }


    fun saveAnime()
    {
        binding.btnSaveAnime.setOnClickListener {

          if(data != null)
          {
              animePresenter.onRemoveAnime(data)
          }
            else
            {
                val anime = Anime()
                anime.Name = binding.txtAnimeName.text.toString()
                anime.Descrip = binding.txtAnimeDescript.text.toString()
                anime.Price = binding.txtAnimePrice.text.toString()
                anime.Rating = binding.txtAnimeRating.text.toString()
                anime.Url = binding.txtAnimeUrl.text.toString()

                animePresenter.onSaveAnime(anime)

            }
            animePresenter.getAnimes()
            this.dialog?.dismiss()
        }
    }

    fun  closeDialog()
    {
        binding.btnCloseDialog.setOnClickListener {
            animePresenter.getAnimes()
            this.dialog?.dismiss()
        }
    }
}