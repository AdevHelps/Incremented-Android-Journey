package com.example.incrementedandroidjourney.exercises.exerciseone

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object ExerciseOneModule {

    @Provides
    @Named("nameValue")
    fun provideName() = "John"

    @Provides
    @Named("lastNameValue")
    fun provideLastName() = "Doe"

    @Provides
    @Named("ageValue")
    fun provideAge(): String {
        val age = 55
        return age.toString()
    }
}