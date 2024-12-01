package com.edwinyosua.core.domain.favorite

import com.edwinyosua.core.data.local.entities.GameEntity
import kotlinx.coroutines.flow.Flow

interface IGameFavoriteRepository {

//    suspend fun insertFavoriteGameList(gameList: List<GameEntity>)

    fun getAllGameFavoriteList(): Flow<List<GameEntity>>

}