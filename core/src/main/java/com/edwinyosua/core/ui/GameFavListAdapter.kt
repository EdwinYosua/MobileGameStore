package com.edwinyosua.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.databinding.ItemGameListBinding

class GameFavListAdapter :
    ListAdapter<GameEntity, GameFavListAdapter.FavGameListHolder>(FAV_DIFF_CALLBACK) {

    inner class FavGameListHolder(private val binding: ItemGameListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GameEntity) {
            binding.apply {
                tvGameTitle.text = data.name
                tvGameRating.text = data.rating.toString()

                Glide.with(itemView.context)
                    .load(data.backgroundImg)
                    .into(ivGameImage)
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
        val FAV_DIFF_CALLBACK: DiffUtil.ItemCallback<GameEntity> =
            object : DiffUtil.ItemCallback<GameEntity>() {
                override fun areItemsTheSame(oldItem: GameEntity, newItem: GameEntity): Boolean =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(oldItem: GameEntity, newItem: GameEntity): Boolean =
                    oldItem.id == newItem.id

            }
    }

}