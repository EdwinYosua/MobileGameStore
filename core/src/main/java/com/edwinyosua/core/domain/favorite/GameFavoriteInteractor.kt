package com.edwinyosua.core.domain.favorite

import kotlinx.coroutines.flow.Flow

class GameFavoriteInteractor(private val gameFavRepo: IGameFavoriteRepository) :
    GameFavoriteUseCase {

    override fun getAllGameFavoriteList(): Flow<List<GameListFavorite>> =
        gameFavRepo.getAllGameFavoriteList()

}