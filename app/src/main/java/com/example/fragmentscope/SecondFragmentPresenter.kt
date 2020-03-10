package com.example.fragmentscope

import com.example.fragmentscope.arch.BasePresenter

class SecondFragmentPresenter: BasePresenter<SecondFragmentView>() {

    private val interactor = App.get().getFragmentComponent().getFragmentInteractor()

    private var secondText = ""

    init {
        cd.add(interactor.getSecondObservable()
            .subscribe {
                getView()?.setSecondText(it)
                secondText = it
            })
    }

    override fun onAttach(view: SecondFragmentView) {
        super.onAttach(view)
        getView()?.setSecondText(secondText)
    }

    fun onButtonClick() {
        interactor.toggleState()
    }
}