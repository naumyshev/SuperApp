package com.naumyshev.superapp.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.naumyshev.superapp.R
import com.naumyshev.superapp.main.screens.general.GeneralFragment
import com.naumyshev.superapp.main.screens.textview.TextViewFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            openGeneralFragment()
        }
    }

    fun openGeneralFragment() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<GeneralFragment>(R.id.fragment_container_view)
        }
    }

    fun openTextViewScreen() {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<TextViewFragment>(R.id.fragment_container_view, TextViewFragment.TAG)
            addToBackStack(TextViewFragment.TAG)
        }
    }
}
