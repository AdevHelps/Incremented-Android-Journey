package com.example.incrementedandroidjourney.exercises.exercisethree

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.incrementedandroidjourney.databinding.ExerciseThreeRecyclerViewRowBinding
import javax.inject.Inject

class RecyclerViewAdapter @Inject constructor(
    private val usersList: List<String>,
): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewViewHolder {
        return RecyclerViewViewHolder(ExerciseThreeRecyclerViewRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewViewHolder, position: Int) {
        val user = usersList[position]
        holder.binding.userTextView.text = user
    }

    inner class RecyclerViewViewHolder(
        val binding: ExerciseThreeRecyclerViewRowBinding
    ): RecyclerView.ViewHolder(binding.root)
}