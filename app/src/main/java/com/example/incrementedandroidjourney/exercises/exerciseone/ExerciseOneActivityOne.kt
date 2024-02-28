package com.example.incrementedandroidjourney.exercises.exerciseone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.incrementedandroidjourney.databinding.ActivityExerciseOneBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class ExerciseOneActivityOne : AppCompatActivity() {

    private lateinit var binding: ActivityExerciseOneBinding
    @Inject @Named("nameValue") lateinit var name: String
    @Inject @Named("lastNameValue") lateinit var lastName: String
    @Inject @Named("ageValue") lateinit var age: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {


            val info = buildString {
                append("Name: $name\n")
                append("Last Name: $lastName\n")
                append("Age: $age")
            }
            exerciseOneTextView.text = info
        }
    }
}