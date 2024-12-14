package com.edwinyosua.core.domain.favorite.repository

import com.edwinyosua.core.domain.favorite.model.GameListFavorite
import kotlinx.coroutines.flow.Flow

interface IGameFavoriteRepository {

    fun getAllGameFavoriteList(): Flow<List<GameListFavorite>>

}