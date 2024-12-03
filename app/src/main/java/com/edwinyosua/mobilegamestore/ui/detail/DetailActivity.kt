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
import com.edwinyosua.core.domain.home.model.GamesList
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

        val gameDetailData = getParcelableExtra(intent, EXTRA_DATA, GamesList::class.java)
        if (gameDetailData != null) {
            showGameDetail(gameDetailData)
            checkGameIsFavorite()
        }
    }


    private fun checkGameIsFavorite() {
        detailViewModel.getGameDetail.observe(this@DetailActivity) { detail ->
            setFavIcon(detail.isFavorite)
            var isFavorite = detail.isFavorite

            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                setFavIcon(isFavorite)
                detailViewModel.setFavorite(detail, isFavorite)
            }
        }
    }

    private fun showGameDetail(games: GamesList) {
        binding.apply {
            detailViewModel.apply {
                games.apply {
                    tvGameName.text = name
                    tvGameRating.text = rating.toString()
                    getDescription(games.id).observe(this@DetailActivity) { gameDesc ->
                        when (gameDesc) {
                            is ApiResponse.Empty -> {}
                            is ApiResponse.Error -> {}
                            is ApiResponse.Loading -> {}
                            is ApiResponse.Success -> {
                                tvGameDesc.text = gameDesc.data.description

//                              PUT THE DATA FROM HOME AND API(GAME DESCRIPTION) TO LOCAL
                                insertGameDataToLocal(games, gameDesc.data)
                            }
                        }
                    }
                    Glide.with(this@DetailActivity)
                        .load(backgroundImage)
                        .into(imvGameImage)
                }


//                CHECK IF THE DATA IS STORED IN LOCAL BY ID SENT FROM HOME UI
//                IF THE DATA IS NOT IN LOCAL, WE APPLY THE DATA FROM HOME UI AND THE DESCRIPTION FROM API INSTEAD
//                getDetail(games.id).observe(this@DetailActivity) { localGameData ->
//                    if (localGameData.id == games.id) {
//                        localGameData.apply {
//                            tvGameName.text = name
//                            tvGameRating.text = rating.toString()
//                            tvGameDesc.text = description
//                            Glide.with(this@DetailActivity)
//                                .load(backgroundImg)
//                                .into(imvGameImage)
//                            setFavIcon(isFavorite)
//                        }
//                    } else {
//                        games.apply {
//                            tvGameName.text = name
//                            tvGameRating.text = rating.toString()
//                            getDescription(id).observe(this@DetailActivity) { desc ->
//                                when (desc) {
//                                    is ApiResponse.Empty -> {}
//                                    is ApiResponse.Error -> {}
//                                    is ApiResponse.Loading -> {}
//                                    is ApiResponse.Success -> {
//                                        tvGameDesc.text = desc.data.description
//
//                                        //every item click, save the item data to local
//                                        //since the list @Home keep updating
//                                        insertGameDataToLocal(games, desc.data)
//                                    }
//                                }
//                            }
//                            Glide.with(this@DetailActivity)
//                                .load(backgroundImage)
//                                .into(imvGameImage)
//                            setFavIcon(false)
//                        }
//                    }
//                  HOW TO SET THE GAME AS FAVORITE ????
//                    fab.setOnClickListener {
//                        var favoriteStatus = localGameData.isFavorite
//                        favoriteStatus = !favoriteStatus
//                        setFavIcon(favoriteStatus)
//                        detailViewModel.setFavorite(localGameData, favoriteStatus)
//                        Log.e("Set Favorite", localGameData.toString())
//                    }
//                }
            }
        }
    }

    private fun setFavIcon(favStatus: Boolean) {
        if (favStatus) {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this@DetailActivity,
                    R.drawable.ic_favorite_white
                )
            )
        } else {
            binding.fab.setImageDrawable(
                ContextCompat.getDrawable(
                    this@DetailActivity,
                    R.drawable.ic_not_favorite_white
                )
            )
        }

    }


    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}