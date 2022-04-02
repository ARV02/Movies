package com.example.movies.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movies.R
import com.example.movies.domain.model.NowPlaying
import com.example.movies.ui.view.MovieDetailsActivity

class NowPlayingAdapter(private var nowPlaying: List<NowPlaying>,
                        private val context: Context
): RecyclerView.Adapter<ViewHolderNowPlaying>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderNowPlaying {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderNowPlaying(layoutInflater.inflate(R.layout.movie_popular_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderNowPlaying, position: Int) {
        val items = nowPlaying[position]
        holder.bind(items)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
            intent.putExtra("poster", items.poster)
            intent.putExtra("title", items.title)
            intent.putExtra("overview",items.overview)
            intent.putExtra("release_date", items.release_date)
            intent.putExtra("id", items.movieId)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = nowPlaying.size
}