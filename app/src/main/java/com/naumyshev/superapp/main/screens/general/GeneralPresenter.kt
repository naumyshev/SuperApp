package com.naumyshev.superapp.main.screens.general

import com.naumyshev.superapp.base.presenter.BasePresenter

class GeneralPresenter: BasePresenter<GeneralContractInterface.View>(), GeneralContractInterface.Presenter {

    override fun onTextViewButtonClick() {
        view?.openTextViewScreen()
    }
}