package com.edwinyosua.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.edwinyosua.core.data.local.entities.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGame(gameData: GameEntity)

    @Update
    fun updateGameData(gameData: GameEntity)

    @Query("SELECT * FROM game_table WHERE favorite = 1")
    fun getAllGameList(): Flow<List<GameEntity>>

    @Query("SELECT * FROM game_table WHERE id = :gameId")
    fun getGameData(gameId: Int): Flow<GameEntity>


}