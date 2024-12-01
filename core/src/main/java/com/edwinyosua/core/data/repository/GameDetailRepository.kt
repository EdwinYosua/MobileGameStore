package com.edwinyosua.core.data.repository

import android.util.Log
import com.edwinyosua.core.data.local.LocalDataSources
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.domain.detail.mapper.toDomain
import com.edwinyosua.core.domain.detail.model.GameDetail
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
    override fun getGameDetail(gameId: String): Flow<ApiResponse<GameDetail>> = flow {

        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameDetail(gameId)
            val gameDetail = response.toDomain()
            if (gameId != ConstVal.emptyString) {
                emit(ApiResponse.Success(gameDetail))
            } else {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            emit(ApiResponse.Error(e.message.toString()))
            e.printStackTrace()
            Log.e("GameDetailRepository/getGameDetail", e.toString())
        }

    }.flowOn(Dispatchers.IO)

    override suspend fun insertFavGame(game: Games, gameDescription: GameDetail) {
        val insertedGameFav = DataMapper.mapGameDataToEntity(game, gameDescription)
        localData.insertGameList(insertedGameFav)
    }
}