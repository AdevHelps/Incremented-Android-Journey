package com.example.incrementedandroidjourney.exercises.exercisetwo

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ExerciseTwoModule {

    @Provides
    fun provideNumbersList() = listOf(1, 2, 3, 4, 5, 6, 7)

}