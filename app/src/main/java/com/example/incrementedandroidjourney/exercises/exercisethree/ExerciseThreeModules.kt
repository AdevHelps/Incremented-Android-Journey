package com.example.incrementedandroidjourney.exercises.exercisethree

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object ExerciseThreeFirstModule {

    @Provides
    fun provideUsersList() = listOf("Alice", "Bob", "Charlie", "David", "Eve")

    @Provides
    fun provideExerciseThreeActivity(): ExerciseThreeActivity {
        return ExerciseThreeActivity()
    }

    @Provides
    fun provideRecyclerViewAdapter(usersList: List<String>): RecyclerViewAdapter {
        return RecyclerViewAdapter(usersList)
    }
}