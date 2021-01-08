package com.prakhar_sharan.tmdbmovieclient.presentation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.prakhar_sharan.tmdbmovieclient.R
import com.prakhar_sharan.tmdbmovieclient.data.model.movie.Movie
import com.prakhar_sharan.tmdbmovieclient.databinding.ActivityMainBinding
import com.prakhar_sharan.tmdbmovieclient.presentation.di.Injector
import com.prakhar_sharan.tmdbmovieclient.presentation.di.movie.MovieAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var mainViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        mainViewModel = ViewModelProvider(this, factory)
            .get(MainViewModel::class.java)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        binding.rvMovie.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.rvMovie.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
//        binding..visibility = View.VISIBLE
        val responseLiveData = mainViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
//                binding.movieProgressBar.visibility = View.GONE
            }else{
//                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}