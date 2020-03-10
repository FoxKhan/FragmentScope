package com.example.fragmentscope.di

import com.example.fragmentscope.FragmentInteractor
import dagger.Module
import dagger.Provides

@Module()
class FragmentModule {

    @Provides
    @FragmentScope
    fun getFragmentInteractor(): FragmentInteractor {
        return FragmentInteractor()
    }
}