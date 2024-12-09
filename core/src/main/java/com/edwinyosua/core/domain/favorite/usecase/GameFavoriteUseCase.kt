package com.edwinyosua.core.domain.favorite.usecase

import com.edwinyosua.core.domain.favorite.model.GameListFavorite
import kotlinx.coroutines.flow.Flow

interface GameFavoriteUseCase {

    fun getAllGameFavoriteList(): Flow<List<GameListFavorite>>

}