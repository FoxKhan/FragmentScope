package com.example.fragmentscope

import com.example.fragmentscope.arch.MvpView

interface SecondFragmentView : MvpView {
    fun setSecondText(text: String)
}