package com.naumyshev.superapp.main.screens.edittext

import com.naumyshev.superapp.base.presenter.BasePresenterInterface
import com.naumyshev.superapp.base.view.BaseViewInterface

interface EditTextContractInterface {

    interface View: BaseViewInterface {
        fun showLoginAndPass()
    }

    interface Presenter: BasePresenterInterface<View> {
        fun onLoginButtonClick()
    }
}