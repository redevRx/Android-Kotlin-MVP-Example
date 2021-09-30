package com.redev.animemvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMain.
        setContentView(R.layout.activity_main)

        initialAppBar()

        //
        initialFragment(savedInstanceState)
    }

    /*
    setting fragment
    * */
    fun initialFragment(savedInstanceState:Bundle?)
    {
        if(R.id.fragment_container != null)
        {
            if(savedInstanceState != null)
            {
                return
            }

            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, HomeFragment.newInstance(supportFragmentManager), null)
                addToBackStack(null)
                commit()
            }
        }
    }

    /*
    setting app bar
    */
    fun initialAppBar()
    {
        setSupportActionBar(null)
    }
}