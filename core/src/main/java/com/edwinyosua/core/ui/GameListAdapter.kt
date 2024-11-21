package com.edwinyosua.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.edwinyosua.core.data.remote.network.ResultsItem
import com.edwinyosua.core.databinding.ItemGameListBinding

class GameListAdapter : ListAdapter<ResultsItem, GameListAdapter.GameListHolder>(DIFF_CALLBACK) {

    inner class GameListHolder(private var binding: ItemGameListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ResultsItem) {
            binding.apply {
                tvGameTitle.text = data.name
                tvGameRating.text = data.rating.toString()
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
        val DIFF_CALLBACK: DiffUtil.ItemCallback<ResultsItem> =
            object : DiffUtil.ItemCallback<ResultsItem>() {
                override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem) =
                    oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: ResultsItem,
                    newItem: ResultsItem
                ) = oldItem.id == newItem.id

            }
    }
}