package com.edwinyosua.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edwinyosua.core.domain.favorite.GameFavoriteUseCase

class FavoriteViewModel(gameFavRepo: GameFavoriteUseCase) : ViewModel() {

    val favGameList = gameFavRepo.getAllGameFavoriteList().asLiveData()
}