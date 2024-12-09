package com.edwinyosua.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edwinyosua.core.databinding.ItemGameListBinding
import com.edwinyosua.core.domain.favorite.model.GameListFavorite

class GameFavListAdapter :
    ListAdapter<GameListFavorite, GameFavListAdapter.FavGameListHolder>(FAV_DIFF_CALLBACK) {

    var onItemClick: ((GameListFavorite) -> Unit)? = null

    inner class FavGameListHolder(private val binding: ItemGameListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GameListFavorite) {
            binding.apply {
                tvGameTitle.text = data.name
                tvGameRating.text = data.rating.toString()

                Glide.with(itemView.context)
                    .load(data.backgroundImg)
                    .into(ivGameImage)


            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GameFavListAdapter.FavGameListHolder = FavGameListHolder(
        ItemGameListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: GameFavListAdapter.FavGameListHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }


    companion object {
        val FAV_DIFF_CALLBACK: DiffUtil.ItemCallback<GameListFavorite> =
            object : DiffUtil.ItemCallback<GameListFavorite>() {
                override fun areItemsTheSame(
                    oldItem: GameListFavorite,
                    newItem: GameListFavorite
                ): Boolean = oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: GameListFavorite,
                    newItem: GameListFavorite
                ): Boolean = oldItem.id == newItem.id

            }
    }

}