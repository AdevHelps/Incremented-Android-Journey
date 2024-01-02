package com.example.incrementedandroidjourney

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.incrementedandroidjourney.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            val call = Client.EndpointsInterfaceImpl.getAllTodos()
            call.enqueue(object : Callback<List<TodoModel>?> {
                override fun onResponse(
                    call: Call<List<TodoModel>?>,
                    response: Response<List<TodoModel>?>,
                ) {
                    setUpRecyclerViewAdapter(response.body())
                }

                override fun onFailure(call: Call<List<TodoModel>?>, t: Throwable) {
                    noDataAvailableTv.visibility = View.VISIBLE
                }
            })
        }
    }

    private fun setUpRecyclerViewAdapter(todoList: List<TodoModel>?){
        binding.apply {
        val adapter = RecyclerViewAdapter(todoList)
            mainRecyclerView.adapter = adapter
            mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }
}