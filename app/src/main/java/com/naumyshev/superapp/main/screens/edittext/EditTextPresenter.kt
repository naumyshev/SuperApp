package com.naumyshev.superapp.main.screens.edittext

import com.naumyshev.superapp.base.presenter.BasePresenter

class EditTextPresenter: BasePresenter<EditTextContractInterface.View>(), EditTextContractInterface.Presenter {
    override fun onLoginButtonClick() {
        view?.showLoginAndPass()
    }
}