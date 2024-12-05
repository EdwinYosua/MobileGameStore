package com.edwinyosua.core.data.local

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.data.local.room.GameDao
import kotlinx.coroutines.flow.Flow

class LocalDataSources(private val gameDao: GameDao) {


    fun getAllGameList(): Flow<List<GameEntity>> = gameDao.getAllGameList()

    fun getGameData(gameId: Int): Flow<GameEntity> = gameDao.getGameData(gameId)

    suspend fun insertGame(gameData: GameEntity) = gameDao.insertGame(gameData)

    fun updateGame(gameData: GameEntity, newState: Boolean) {
        gameData.isFavorite = newState
        gameDao.updateGameData(gameData)
    }

}