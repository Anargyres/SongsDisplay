package com.example.leboncointest.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.leboncointest.R
import com.example.leboncointest.domain.SongsElements

class SongAdapter(
    var listSongs: List<SongsElements>
) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.songs_view_holder, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = listSongs[position]

        holder.bindItem(model)
    }

    override fun getItemCount() = listSongs.size

    class ViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private var songImage: ImageView = itemView.findViewById(R.id.songs_image)
        private var songTitle: TextView = itemView.findViewById(R.id.songs_title_name)
        private var songAlbum: TextView = itemView.findViewById(R.id.songs_album_name)

        fun bindItem(model: SongsElements) {
            with(itemView) {
                Glide.with(itemView).load(model.thumbnailUrl).into(songImage)
                songTitle.text = model.titre
                songAlbum.text = model.albumId
            }
        }
    }
}