package com.edwinyosua.core.data.repository

import android.util.Log
import com.edwinyosua.core.data.local.LocalDataSources
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.domain.Games
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.home.model.GamesList
import com.edwinyosua.core.utils.AppExecutors
import com.edwinyosua.core.utils.ConstVal
import com.edwinyosua.core.utils.DataMapper
import com.edwinyosua.core.utils.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class GameDetailRepository(
    private val localData: LocalDataSources,
    private val apiService: ApiService,
    private val appExecutor: AppExecutors
) : IGameDetailRepository {


    override fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>> = flow {

        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameDescription(gameId)
            val gameData = response.toDomain()
            if (gameData.description != ConstVal.emptyString) {
                emit(ApiResponse.Success(gameData))
            }

            if (gameData.description == ConstVal.emptyString) {
                emit(ApiResponse.Empty)
            }

        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
            Log.e("GameDetailRepository", e.toString())
        }
    }.flowOn(Dispatchers.IO)

    override fun setFavorite(gameData: Games, newState: Boolean) {
        val mappedGameData = DataMapper.mapDomainToEntity(gameData)
        appExecutor.diskIO().execute { localData.updateGame(mappedGameData, newState) }
    }

    override fun getGameDetail(gameId: Int): Flow<Games> =
        localData.getGameData(gameId).map {
            DataMapper.mapEntityToDomain(it)
        }.flowOn(Dispatchers.IO)


    override suspend fun insertGameData(game: GamesList, gameDescription: GameDescription) {
        val gameFavToEntity = DataMapper.mapGameDataToEntity(game, gameDescription)
        localData.insertGame(gameFavToEntity)
    }

}