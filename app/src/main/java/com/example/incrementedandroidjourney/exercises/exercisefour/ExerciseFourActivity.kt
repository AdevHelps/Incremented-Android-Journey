package com.example.incrementedandroidjourney.exercises.exercisefour

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.incrementedandroidjourney.databinding.ActivityExerciseFourBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExerciseFourActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseFourBinding
    @Inject lateinit var myInterface: MyInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseFourBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            textView.text = myInterface.doSomething()
        }
    }
}