package com.example.fragmentscope.di

import com.example.fragmentscope.FragmentInteractor
import dagger.Component

@Component(modules = [FragmentModule::class])
@FragmentScope
interface FragmentComponent {
    fun getFragmentInteractor(): FragmentInteractor
}