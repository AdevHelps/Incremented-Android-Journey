package com.example.incrementedandroidjourney

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.incrementedandroidjourney.databinding.RecyclerViewCardDesignBinding

class RecyclerViewAdapter(
    private val todoList: List<TodoModel>?
): RecyclerView.Adapter<RecyclerViewAdapter.TodoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(RecyclerViewCardDesignBinding.inflate(LayoutInflater.from(
            parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return todoList?.size ?: 0
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val data = todoList?.get(position)
        holder.binding.apply {
            titleTv.text = data?.title
            idTv.text = data?.id.toString()
            todoCheckBox.isChecked = data?.completed ?: false
        }
    }

    class TodoViewHolder(val binding: RecyclerViewCardDesignBinding
    ): RecyclerView.ViewHolder(binding.root)

}