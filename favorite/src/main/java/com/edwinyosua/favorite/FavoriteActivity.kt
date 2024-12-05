package com.edwinyosua.favorite

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.edwinyosua.core.ui.GameFavListAdapter
import com.edwinyosua.favorite.databinding.ActivityFavoriteBinding
import com.edwinyosua.mobilegamestore.ui.detail.DetailActivity
import org.koin.android.ext.android.inject
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding
    private val favoriteViewModel: FavoriteViewModel by inject()
    private val gameFavListAdapter: GameFavListAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//      SET THE FAVORITE LIST TO RECYCLER VIEW
        showGameList()

        gameFavListAdapter.onItemClick = { selectedData ->
            val intent = Intent(this@FavoriteActivity, DetailActivity::class.java)
            val gameId = selectedData.id
//          SEND GAME ID TO DETAIL
            intent.putExtra(DetailActivity.EXTRA_ID, gameId.toString())
            startActivity(intent)
        }
    }

    private fun showGameList() {
        favoriteViewModel.favGameList.observe(this@FavoriteActivity) { favList ->
            gameFavListAdapter.submitList(favList)
            with(binding.rvFavGame) {
                layoutManager = LinearLayoutManager(context)
                adapter = gameFavListAdapter
            }
        }
    }
}