package com.edwinyosua.core.domain.favorite.usecase

import com.edwinyosua.core.domain.favorite.model.GameListFavorite
import com.edwinyosua.core.domain.favorite.repository.IGameFavoriteRepository
import kotlinx.coroutines.flow.Flow

class GameFavoriteInteractor(private val gameFavRepo: IGameFavoriteRepository) :
    GameFavoriteUseCase {

    override fun getAllGameFavoriteList(): Flow<List<GameListFavorite>> =
        gameFavRepo.getAllGameFavoriteList()

}