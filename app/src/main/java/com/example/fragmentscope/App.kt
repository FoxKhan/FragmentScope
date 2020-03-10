package com.example.fragmentscope

import android.app.Application
import com.example.fragmentscope.di.DaggerFragmentComponent
import com.example.fragmentscope.di.FragmentComponent
import com.example.fragmentscope.di.FragmentModule

class App : Application() {

    private var fragmentComponent: FragmentComponent? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    fun getFragmentComponent(): FragmentComponent {
        if (fragmentComponent == null)
            fragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule())
                .build()
        return fragmentComponent!!
    }

    fun clearFragmentComponent() {
        fragmentComponent = null
    }

    companion object {
        lateinit var instance: App
        fun get(): App = instance
    }
}