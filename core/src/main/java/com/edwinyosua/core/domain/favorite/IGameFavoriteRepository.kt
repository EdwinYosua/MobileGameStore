package com.edwinyosua.core.domain.favorite

import kotlinx.coroutines.flow.Flow

interface IGameFavoriteRepository {

    fun getAllGameFavoriteList(): Flow<List<GameListFavorite>>

}