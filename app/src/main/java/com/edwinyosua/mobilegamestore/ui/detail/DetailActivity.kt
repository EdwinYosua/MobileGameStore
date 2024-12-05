package com.edwinyosua.mobilegamestore.ui.detail

import android.os.Bundle
import android.widget.Toast
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

//      RECEIVE THE DATA ID
        val gameDetailDataHome = getParcelableExtra(intent, EXTRA_DATA, GamesList::class.java) //FROM HOME PAGE
        val gameIdDataFromFavorite = intent.getStringExtra(EXTRA_ID) //FROM FAVORITE PAGE

        showGameDetail(gameDetailDataHome, gameIdDataFromFavorite)
        checkGameIsFavorite()
    }


    private fun checkGameIsFavorite() {
//      CHECK IF THE GAME IS FAVORITE OR NOT FROM LOCAL
        detailViewModel.gameDetail.observe(this@DetailActivity) { detail ->
            setFavIcon(detail.isFavorite)
            var isFavorite = detail.isFavorite


            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                setFavIcon(isFavorite)
                detailViewModel.setFavorite(detail, isFavorite)

//              TO INFORM THE FAVORITE STATUS
                if (isFavorite) {
                    Toast.makeText(this@DetailActivity, "Added To Favorite", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this@DetailActivity, "Removed From Favorite", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    private fun showGameDetail(games: GamesList?, gameId: String?) {
        binding.apply {
            detailViewModel.apply {
                if (gameId != null) {
//                  GET DATA FROM LOCAL
                    getDetail(gameId.toInt())
                    gameDetail.observe(this@DetailActivity) { localData ->
                        localData.apply {
                            tvGameName.text = name
                            tvGameRating.text = rating.toString()
                            tvGameDesc.text = description
                            Glide.with(this@DetailActivity).load(backgroundImg).into(imvGameImage)
                        }
                    }
                } else games?.apply {
//                  GET DESCRIPTION DATA FROM API
                    tvGameName.text = name
                    tvGameRating.text = rating.toString()

                    Glide.with(this@DetailActivity).load(backgroundImage).into(imvGameImage)

                    getDescription(games.id).observe(this@DetailActivity) { gameDesc ->
                        when (gameDesc) {
                            is ApiResponse.Empty -> {}
                            is ApiResponse.Loading -> {}
                            is ApiResponse.Error -> {}
                            is ApiResponse.Success -> {
                                tvGameDesc.text = gameDesc.data.description
//                              STORE DATA FROM HOME PAGE AND DESCRIPTION API TO LOCAL
                                insertGameDataToLocal(games, gameDesc.data)
                            }
                        }
                    }
                }
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
        const val EXTRA_ID = "extra_Id"
        const val EXTRA_DATA = "extra_data"
    }
}