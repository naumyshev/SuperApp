package com.naumyshev.superapp.main.screens.general

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.R
import com.naumyshev.superapp.base.view.BaseFragment
import com.naumyshev.superapp.databinding.FragmentGeneralBinding
import com.naumyshev.superapp.main.MainActivity

//class GeneralFragment: Fragment(R.layout.fragment_general) {
class GeneralFragment: BaseFragment(R.layout.fragment_general), GeneralContractInterface.View {

    private val generalPresenter = GeneralPresenter()
    private var fragmentGeneralBinding: FragmentGeneralBinding? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentGeneralBinding = FragmentGeneralBinding.bind(view)

        generalPresenter.attach(this)

        fragmentGeneralBinding?.buttonTextview?.setOnClickListener { generalPresenter.onTextViewButtonClick() }

    }



    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        generalPresenter.detach()
        fragmentGeneralBinding = null
        super.onDestroyView()
    }

    override fun openTextViewScreen() {
        (activity as? MainActivity)?.openTextViewScreen()
    }
}



