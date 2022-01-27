package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding
import com.example.recyclerviewproject.model.Item
import com.example.recyclerviewproject.model.MemoItem
import com.example.recyclerviewproject.model.OnlyTitleItem

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val adapter by lazy {
        BaseListAdapter()
    }

    val item by lazy {
        ArrayList<Item>().apply {
            (0..10).forEach {
                add(MemoItem("title$it", "description$it"))
                add(OnlyTitleItem("title$it"))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerViewInit()
        adapter.submitList(item)
    }

    fun recyclerViewInit(){
        binding.recyclerView.run{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }
}