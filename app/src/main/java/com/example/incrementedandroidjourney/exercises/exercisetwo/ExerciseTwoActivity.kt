package com.example.incrementedandroidjourney.exercises.exercisetwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.incrementedandroidjourney.databinding.ActivityExerciseTwoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExerciseTwoActivity: AppCompatActivity() {

    private lateinit var binding: ActivityExerciseTwoBinding
    private val exerciseTwoViewModel by viewModels<ExerciseTwoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            exerciseTwoViewModel.doSomething().observe(this@ExerciseTwoActivity) { number ->
                numberTextView.text = number.toString()
            }
        }
    }
}