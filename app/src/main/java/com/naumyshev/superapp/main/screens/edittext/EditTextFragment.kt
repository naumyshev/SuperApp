package com.naumyshev.superapp.main.screens.edittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import com.naumyshev.superapp.R
import com.naumyshev.superapp.databinding.FragmentEditTextBinding

class EditTextFragment: Fragment(R.layout.fragment_edit_text), EditTextContractInterface.View {
    companion object {
        const val TAG = "EditTextFragment"
        const val STATE_FOCUS = "focus"
        const val STATE_LOGIN = "login"
        const val STATE_PASSWORD = "password"
    }

    private val editTextPresenter = EditTextPresenter()
    private var fragmentEditTextBinding: FragmentEditTextBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            fragmentEditTextBinding?.focusTv?.text = savedInstanceState.getCharSequence(STATE_FOCUS)
            fragmentEditTextBinding?.loginTv?.text = savedInstanceState.getCharSequence(STATE_LOGIN)
            fragmentEditTextBinding?.passwordTv?.text = savedInstanceState.getCharSequence(STATE_PASSWORD)
        }

        fragmentEditTextBinding = FragmentEditTextBinding.bind(view)
        editTextPresenter.attach(this)

        fragmentEditTextBinding?.toolbar?.title = getString(R.string.edit_text)
        fragmentEditTextBinding?.toolbar?.setNavigationOnClickListener { activity?.onBackPressed() }
        fragmentEditTextBinding?.loginButton?.setOnClickListener { editTextPresenter.onLoginButtonClick() }

        fragmentEditTextBinding?.loginEt?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                fragmentEditTextBinding?.loginButton?.isEnabled =
                    !p0.isNullOrEmpty() && fragmentEditTextBinding?.passwordEt?.text?.isNotEmpty() == true
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        fragmentEditTextBinding?.passwordEt?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                fragmentEditTextBinding?.loginButton?.isEnabled =
                    !p0.isNullOrEmpty() && fragmentEditTextBinding?.loginEt?.text?.isNotEmpty() == true

            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        
        fragmentEditTextBinding?.inputEt?.setOnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                fragmentEditTextBinding?.focusTv?.text = getString(R.string.has_focus)
            } else {
                fragmentEditTextBinding?.focusTv?.text = getString(R.string.has_not_focus)
            }
        }

        fragmentEditTextBinding?.inputEt?.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                fragmentEditTextBinding?.inputTv?.text = fragmentEditTextBinding?.inputEt?.editableText?.toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putCharSequence(STATE_FOCUS, fragmentEditTextBinding?.focusTv?.text)
        outState.putCharSequence(STATE_LOGIN, fragmentEditTextBinding?.loginTv?.text)
        outState.putCharSequence(STATE_PASSWORD, fragmentEditTextBinding?.passwordTv?.text)
    }

    override fun onDestroyView() {
        fragmentEditTextBinding = null
        super.onDestroyView()
    }

    override fun showLoginAndPass(){
        fragmentEditTextBinding?.loginTv?.text = fragmentEditTextBinding?.loginEt?.editableText?.toString()
        fragmentEditTextBinding?.passwordTv?.text = fragmentEditTextBinding?.passwordEt?.editableText?.toString()
    }
}