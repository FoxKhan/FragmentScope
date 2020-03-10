package com.example.fragmentscope.arch

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<VIEW: MvpView> : ViewModel() {

    private var view : VIEW? = null
    val cd = CompositeDisposable()

    protected fun getView() = view

    open fun onAttach(view : VIEW){
        this.view = view
    }

    open fun onDetach() {
        view = null
    }

    override fun onCleared() {
        cd.clear()
        super.onCleared()
    }

}