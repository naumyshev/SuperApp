package com.naumyshev.superapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            openGeneralFragment()
        }
    }

    private fun openGeneralFragment(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<GeneralFragment>(R.id.fragment_container_view)
        }
    }

}




