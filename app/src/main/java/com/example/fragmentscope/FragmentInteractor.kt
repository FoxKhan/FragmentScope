package com.example.fragmentscope

import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class  FragmentInteractor {

    private var toggleState = true
    private val firstSubject = BehaviorSubject.createDefault("Main")
    private val secondSubject = BehaviorSubject.createDefault("Second")

    fun getFirstObservable (): Observable<String> = firstSubject

    fun getSecondObservable (): Observable<String> = secondSubject

    fun toggleState() {
        secondSubject.onNext(if (toggleState) "POP" else "Second")
        toggleState = !toggleState
    }

}