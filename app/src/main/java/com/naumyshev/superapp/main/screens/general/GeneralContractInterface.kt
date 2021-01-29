package com.naumyshev.superapp.main.screens.general

import com.naumyshev.superapp.base.presenter.BasePresenterInterface
import com.naumyshev.superapp.base.view.BaseViewInterface

interface GeneralContractInterface {

    interface View: BaseViewInterface {

        fun openTextViewScreen()
    }

    interface Presenter: BasePresenterInterface<View> {

        fun onTextViewButtonClick()
    }
}