package com.edwinyosua.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.edwinyosua.core.data.local.entities.GameEntity

@Database(entities = [GameEntity::class], version = 1, exportSchema = false)
abstract class GameDatabase : RoomDatabase() {


    abstract fun gameDao() : GameDao

}