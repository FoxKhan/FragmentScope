package com.example.fragmentscope

import com.example.fragmentscope.arch.BasePresenter

class MainFragmentPresenter: BasePresenter<MainFragmentView>() {

    private val interactor = App.get().getFragmentComponent().getFragmentInteractor()

    private var mainText = ""
    private var secondText = ""

    init {
        cd.add(interactor.getFirstObservable()
            .subscribe {
                getView()?.setMainText(it)
                mainText = it
            })
        cd.add(interactor.getSecondObservable()
            .subscribe {
                getView()?.setSecondText(it)
                secondText = it
            })
    }

    override fun onAttach(view: MainFragmentView) {
        super.onAttach(view)
        getView()?.setMainText(mainText)
        getView()?.setSecondText(secondText)
    }

    override fun onCleared() {
        App.get().clearFragmentComponent()
        super.onCleared()
    }
}