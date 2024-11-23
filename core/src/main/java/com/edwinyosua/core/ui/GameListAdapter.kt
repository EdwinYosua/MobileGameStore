package com.edwinyosua.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edwinyosua.core.databinding.ItemGameListBinding
import com.edwinyosua.core.domain.home.model.Games

class GameListAdapter : ListAdapter<Games, GameListAdapter.GameListHolder>(DIFF_CALLBACK) {

    inner class GameListHolder(private var binding: ItemGameListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Games) {
            binding.apply {
                tvGameTitle.text = data.name
                tvGameRating.text = data.rating.toString()

                Glide.with(itemView.context)
                    .load(data.backgroundImage)
                    .into(ivGameImage)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GameListHolder = GameListHolder(
        ItemGameListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: GameListHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }


    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Games> =
            object : DiffUtil.ItemCallback<Games>() {
                override fun areItemsTheSame(oldItem: Games, newItem: Games) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: Games,
                    newItem: Games
                ) = oldItem.id == newItem.id

            }
    }
}