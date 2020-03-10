package com.example.fragmentscope

import com.example.fragmentscope.arch.MvpView

interface MainFragmentView : MvpView {
    fun setMainText(text: String)
    fun setSecondText(text: String)

}