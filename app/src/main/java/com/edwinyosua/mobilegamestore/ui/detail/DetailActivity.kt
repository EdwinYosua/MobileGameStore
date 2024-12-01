package com.edwinyosua.mobilegamestore.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.home.model.Games
import com.edwinyosua.mobilegamestore.R
import com.edwinyosua.mobilegamestore.databinding.ActivityDetailBinding
import org.koin.android.ext.android.inject

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val detailViewModel: DetailViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val gameDetailData = getParcelableExtra(intent, EXTRA_DATA, Games::class.java)
        if (gameDetailData != null) {
            showGameDetail(gameDetailData)
        }

    }

    private fun showGameDetail(games: Games) {

        binding.apply {
            tvGameName.text = games.name
            tvGameRating.text = games.rating.toString()

            detailViewModel.getGameDetail(games.id.toString())
            detailViewModel.gameDetail.observe(this@DetailActivity) { gameDetail ->
                when (gameDetail) {
                    is ApiResponse.Loading -> {}
                    is ApiResponse.Success -> {
                        tvGameDesc.text = gameDetail.data.description
                        fab.setOnClickListener {
                            detailViewModel.setFavorite(games, gameDetail.data)
                            setFavIcon(true)
                        }
                    }

                    is ApiResponse.Empty -> tvGameDesc.text = "No Description"
                    is ApiResponse.Error -> {}
                }

            }


            Glide.with(this@DetailActivity)
                .load(games.backgroundImage)
                .into(imvGameImage)
        }
    }

    private fun setFavIcon(favStatus: Boolean) {
        binding.apply {
            fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this@DetailActivity,
                    R.drawable.ic_favorite_white
                )
            )
        }
    }


    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}