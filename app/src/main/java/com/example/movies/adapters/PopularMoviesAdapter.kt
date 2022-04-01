package com.example.movies.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.data.models.MovieModel
import com.example.movies.ui.view.MovieDetailsActivity

class PopularMoviesAdapter(private var popularMoviesList: List<MovieModel>,
                           private val context: Context): RecyclerView.Adapter<ViewHolderPopularMovie>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPopularMovie {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderPopularMovie(layoutInflater.inflate(R.layout.movie_popular_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderPopularMovie, position: Int) {
        val items = popularMoviesList[position]
        holder.bind(items)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
            intent.putExtra("poster", items.poster)
            intent.putExtra("title", items.title)
            intent.putExtra("overview",items.overview)
            intent.putExtra("release_date", items.release_date)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = popularMoviesList.size
}