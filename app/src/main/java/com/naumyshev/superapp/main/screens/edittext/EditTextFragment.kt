package com.naumyshev.superapp.main.screens.edittext

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.R
import com.naumyshev.superapp.databinding.FragmentEditTextBinding

class EditTextFragment: Fragment(R.layout.fragment_edit_text) {
    companion object {
        const val TAG = "EditTextFragment"
    }

    private var fragmentEditTextBinding: FragmentEditTextBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentEditTextBinding = FragmentEditTextBinding.bind(view)
        fragmentEditTextBinding?.toolbar?.title = "EditText"

        fragmentEditTextBinding?.toolbar?.setNavigationOnClickListener { activity?.onBackPressed() }
    }
}