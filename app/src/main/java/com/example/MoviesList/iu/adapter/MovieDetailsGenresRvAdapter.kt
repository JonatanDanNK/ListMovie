package com.example.MoviesList.iu.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.MoviesList.R
import com.google.android.material.chip.Chip
import com.monique.projetointegrador.domain.model.Genre

class MovieDetailsGenresRvAdapter(private var dataset: List<Genre> = mutableListOf()): RecyclerView.Adapter<MovieDetailsGenresRvAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie_genres, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemGenre?.text = dataset[position].name
    }

    override fun getItemCount() = dataset.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val itemGenre: Chip? = view.findViewById(R.id.itemGenre)
    }
}
