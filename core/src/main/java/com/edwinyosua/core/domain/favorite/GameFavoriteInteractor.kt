package com.edwinyosua.core.domain.favorite

import com.edwinyosua.core.data.local.entities.GameEntity
import kotlinx.coroutines.flow.Flow

class GameFavoriteInteractor(private val gameFavRepo: IGameFavoriteRepository) :
    GameFavoriteUseCase {

    override fun getAllGameFavoriteList(): Flow<List<GameEntity>> =
        gameFavRepo.getAllGameFavoriteList()

}