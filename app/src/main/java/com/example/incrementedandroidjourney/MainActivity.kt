package com.example.incrementedandroidjourney

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.incrementedandroidjourney.exercises.exercisefour.ExerciseFourActivity
import com.example.incrementedandroidjourney.exercises.exerciseone.ExerciseOneActivityOne
import com.example.incrementedandroidjourney.exercises.exercisethree.ExerciseThreeActivity
import com.example.incrementedandroidjourney.exercises.exercisetwo.ExerciseTwoActivity
import com.example.incrementedandroidjourney.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            exerciseOneButton.setOnClickListener { openActivity(ExerciseOneActivityOne()) }

            exerciseTwoButton.setOnClickListener { openActivity(ExerciseTwoActivity()) }

            exerciseThreeButton.setOnClickListener { openActivity(ExerciseThreeActivity()) }

            exerciseFourButton.setOnClickListener { openActivity(ExerciseFourActivity()) }
        }
    }

    private fun openActivity(activity: Activity) {
        Intent(this@MainActivity, activity::class.java).also {
            startActivity(it)
        }
    }
}