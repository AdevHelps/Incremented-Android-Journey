package com.example.incrementedandroidjourney.exercises.exercisetwo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExerciseTwoViewModel @Inject constructor(): ViewModel() {

    @Inject lateinit var numbersList: List<Int>
    private val numberLiveData = MutableLiveData<Int>()

    fun doSomething(): MutableLiveData<Int> {
        val lastIndex = numbersList.lastIndex
        val firstIndex = numbersList.first()
        val result = (firstIndex + lastIndex) * 6
        numberLiveData.value = result
        return numberLiveData
    }
}