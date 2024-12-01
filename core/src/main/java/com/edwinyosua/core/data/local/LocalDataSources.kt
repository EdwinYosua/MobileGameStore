package com.edwinyosua.core.data.local

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSources(private val gameDao: GameDao) {


    fun getAllGameList(): Flow<List<GameEntity>> = gameDao.getAllGameList()

    suspend fun insertGameList(gameList: GameEntity) = gameDao.insertGameList(gameList)

}