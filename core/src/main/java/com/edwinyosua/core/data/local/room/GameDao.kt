package com.edwinyosua.core.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.edwinyosua.core.data.local.entities.GameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGameList(gameList: GameEntity)

    @Query("SELECT * FROM game_table ORDER BY id ASC")
    fun getAllGameList(): Flow<List<GameEntity>>
}