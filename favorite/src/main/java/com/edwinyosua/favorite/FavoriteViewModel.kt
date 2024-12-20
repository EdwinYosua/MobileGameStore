package com.edwinyosua.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edwinyosua.core.domain.favorite.usecase.GameFavoriteUseCase

class FavoriteViewModel(gameFavRepo: GameFavoriteUseCase) : ViewModel() {

    val favGameList by lazy { gameFavRepo.getAllGameFavoriteList().asLiveData() }
}