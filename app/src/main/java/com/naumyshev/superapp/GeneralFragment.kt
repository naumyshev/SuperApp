package com.naumyshev.superapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.databinding.FragmentGeneralBinding

class GeneralFragment : Fragment(R.layout.fragment_general){

    private var fragmentGeneralBinding: FragmentGeneralBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentGeneralBinding = FragmentGeneralBinding.bind(view)

        fragmentGeneralBinding?.buttonTextview?.setOnClickListener { (activity as? MainActivity)?.openTextViewScreen() }
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        fragmentGeneralBinding = null
        super.onDestroyView()
    }
}



