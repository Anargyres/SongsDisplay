package com.example.leboncointest.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.leboncointest.R
import com.example.leboncointest.presentation.MainViewModel
import com.example.leboncointest.presentation.adapter.SongAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: SongAdapter
    private var songsRecyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        songsRecyclerView = findViewById(R.id.songs_recycler_view)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        initObserver()
    }

    private fun initObserver() {
        mainViewModel.liveDataSongs.observe(this, Observer {
            layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
            adapter = SongAdapter(it)

            songsRecyclerView?.apply {
                layoutManager = layoutManager
                adapter = adapter
            }
        })
    }
}