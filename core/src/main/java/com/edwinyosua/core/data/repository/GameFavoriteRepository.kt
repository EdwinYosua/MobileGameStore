package com.edwinyosua.core.data.repository

import com.edwinyosua.core.data.local.LocalDataSources
import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.domain.favorite.IGameFavoriteRepository
import kotlinx.coroutines.flow.Flow

class GameFavoriteRepository(private val localData: LocalDataSources) : IGameFavoriteRepository {


    override fun getAllGameFavoriteList(): Flow<List<GameEntity>> = localData.getAllGameList()
}