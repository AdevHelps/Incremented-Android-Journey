package com.example.incrementedandroidjourney.exercises.exercisethree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.incrementedandroidjourney.databinding.ActivityExerciseThreeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExerciseThreeActivity: AppCompatActivity() {

    private lateinit var binding: ActivityExerciseThreeBinding
    @Inject lateinit var recyclerViewAdapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseThreeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            exerciseThreeRecyclerView.adapter = recyclerViewAdapter
            exerciseThreeRecyclerView.layoutManager =
                LinearLayoutManager(this@ExerciseThreeActivity)
        }
    }
}