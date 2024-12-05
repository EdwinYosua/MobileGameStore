package com.edwinyosua.core.domain.favorite

import kotlinx.coroutines.flow.Flow

interface GameFavoriteUseCase {

    fun getAllGameFavoriteList(): Flow<List<GameListFavorite>>

}