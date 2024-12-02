package com.edwinyosua.core.data.repository

import android.util.Log
import com.edwinyosua.core.data.local.LocalDataSources
import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.domain.detail.mapper.toDomain
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.home.model.Games
import com.edwinyosua.core.utils.ConstVal
import com.edwinyosua.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameDetailRepository(
    private val localData: LocalDataSources,
    private val apiService: ApiService
) : IGameDetailRepository {


    override fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>> = flow {

        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameDescription(gameId)
            val gameData = response.toDomain()

            if (gameData.toString() != ConstVal.emptyString) {
                emit(ApiResponse.Success(gameData))
            }

            if (gameData.toString() == ConstVal.emptyString) {
                emit(ApiResponse.Empty)
            }

        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
            Log.e("GameDetailRepository", e.toString())
        }
    }.flowOn(Dispatchers.IO)

    override fun getGameDetail(gameId: Int): Flow<GameEntity> = localData.getGameData(gameId).flowOn(Dispatchers.IO)

    override suspend fun insertGameData(game: Games, gameDescription: GameDescription) {
        val gameFav = DataMapper.mapGameDataToEntity(game, gameDescription)
        localData.insertGame(gameFav)
    }

}