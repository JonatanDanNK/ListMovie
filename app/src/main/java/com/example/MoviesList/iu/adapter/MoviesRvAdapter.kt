package com.monique.projetointegrador.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.MoviesList.R
import com.example.MoviesList.iu.ClickListener
import com.monique.projetointegrador.data.base.Constants
import com.monique.projetointegrador.domain.model.Movie

class MoviesRvAdapter(
    val context: Context,
    private val listener: ClickListener? = null,
    var dataset: MutableList<Movie> = mutableListOf()
): RecyclerView.Adapter<MoviesRvAdapter.ViewHolder>() {


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var imgMovie: ImageView? = view.findViewById(R.id.imgMovie)
        var titleMovie: TextView? = view.findViewById(R.id.titleMovie)
        var rateMovie: TextView? = view.findViewById(R.id.rateMovie)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_movie, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(dataset[position].imgHome !== ""){
            holder.imgMovie?.let { Glide.with(context).load(Constants.BASE_URL_IMAGE.value + dataset[position].imgHome).into(it) }
        }
        holder.titleMovie?.text = dataset[position].title
        holder.rateMovie?.text = dataset[position].getRating()

        holder.imgMovie?.setOnClickListener {
            listener?.openMovieDetails(dataset[position].id)
        }

    }

    override fun getItemCount() = 10

}
