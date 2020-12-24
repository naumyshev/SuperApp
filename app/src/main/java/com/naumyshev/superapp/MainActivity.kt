package com.naumyshev.superapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null){
            openGeneralFragment()
        }
    }

    fun openGeneralFragment(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<GeneralFragment>(R.id.fragment_container_view)
        }
    }

    fun openTextViewScreen(){
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<TextViewFragment>(R.id.fragment_container_view)
        }
    }
}






