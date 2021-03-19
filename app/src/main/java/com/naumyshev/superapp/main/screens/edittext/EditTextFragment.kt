package com.naumyshev.superapp.main.screens.edittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.R
import com.naumyshev.superapp.databinding.FragmentEditTextBinding

class EditTextFragment: Fragment(R.layout.fragment_edit_text), EditTextContractInterface.View {
    companion object {
        const val TAG = "EditTextFragment"
    }

    private val editTextPresenter = EditTextPresenter()
    private var fragmentEditTextBinding: FragmentEditTextBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentEditTextBinding = FragmentEditTextBinding.bind(view)

        fragmentEditTextBinding?.toolbar?.title = getString(R.string.edit_text)
        fragmentEditTextBinding?.toolbar?.setNavigationOnClickListener { activity?.onBackPressed() }
        fragmentEditTextBinding?.loginButton?.setOnClickListener { editTextPresenter.onLoginButtonClick() }

        fragmentEditTextBinding?.loginEt?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                fragmentEditTextBinding?.loginButton?.isEnabled =
                    !p0.isNullOrEmpty() && fragmentEditTextBinding?.passwordEt?.text?.isNullOrEmpty() == true
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }

    override fun onDestroyView() {
        fragmentEditTextBinding = null
        super.onDestroyView()
    }

    override fun saveLogin(){
        //to do body
    }
}