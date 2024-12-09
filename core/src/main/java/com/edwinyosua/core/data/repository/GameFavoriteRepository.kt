package com.edwinyosua.core.data.repository

import com.edwinyosua.core.data.local.LocalDataSources
import com.edwinyosua.core.domain.favorite.model.GameListFavorite
import com.edwinyosua.core.domain.favorite.repository.IGameFavoriteRepository
import com.edwinyosua.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GameFavoriteRepository(private val localData: LocalDataSources) : IGameFavoriteRepository {


    override fun getAllGameFavoriteList(): Flow<List<GameListFavorite>> =
        localData.getAllGameList().map { DataMapper.mapFavEntityToFavDomain(it) }
}