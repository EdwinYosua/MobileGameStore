package com.edwinyosua.core.data.remote.detail

import android.util.Log
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.domain.detail.mapper.toDomain
import com.edwinyosua.core.domain.detail.model.GameDetail
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameDetailRepository(private val apiService: ApiService) : IGameDetailRepository {
    override fun getGameDetail(gameId: String): Flow<ApiResponse<GameDetail>> = flow {

        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameDetail(gameId)
            val gameDetail = response.toDomain()
            if (gameId != "") {
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
}