package com.edwinyosua.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.edwinyosua.core.databinding.ItemGameListBinding
import com.edwinyosua.core.domain.home.model.GamesList

class GameListAdapter : ListAdapter<GamesList, GameListAdapter.GameListHolder>(DIFF_CALLBACK) {

    var onItemClick: ((GamesList) -> Unit)? = null

    inner class GameListHolder(private var binding: ItemGameListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: GamesList) {
            binding.apply {
                tvGameTitle.text = data.name
                tvGameRating.text = data.rating.toString()

                Glide.with(itemView.context)
                    .load(data.backgroundImage)
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
    ): GameListHolder = GameListHolder(
        ItemGameListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: GameListHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }


    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<GamesList> =
            object : DiffUtil.ItemCallback<GamesList>() {
                override fun areItemsTheSame(oldItem: GamesList, newItem: GamesList) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: GamesList,
                    newItem: GamesList
                ) = oldItem.id == newItem.id

            }
    }
}