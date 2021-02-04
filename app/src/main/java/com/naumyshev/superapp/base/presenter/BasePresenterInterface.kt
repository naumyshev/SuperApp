package com.naumyshev.superapp.base.presenter

import com.naumyshev.superapp.base.view.BaseViewInterface

interface BasePresenterInterface<V: BaseViewInterface> {

    val isAttached: Boolean

    fun attach(view: V)

    fun detach()

}
