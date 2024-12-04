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

//      RECEIVE THE DATA FROM HOME PAGE
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
//                              FETCH ITEM DESCRIPTION FROM API
//                              SINCE THE DATA AT HOME PAGE COMES FROM DIFFERENT GSON OBJECT
                                tvGameDesc.text = gameDesc.data.description

//                              PUT THE DATA FROM HOME AND API(GAME DESCRIPTION) TO LOCAL
//                              EVERY TIME THE ITEM DETAIL CLICKED
//                              BECAUSE THE LIST AT HOME PAGE KEEP UPDATING
                                insertGameDataToLocal(games, gameDesc.data)
                            }
                        }
                    }
                    Glide.with(this@DetailActivity)
                        .load(backgroundImage)
                        .into(imvGameImage)
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
        const val EXTRA_DATA = "extra_data"
    }
}