package com.edwinyosua.core.data.repository

import android.util.Log
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.domain.home.mapper.toDomain
import com.edwinyosua.core.domain.home.model.Games
import com.edwinyosua.core.domain.home.repository.IGameListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameListRepository(
    private val apiService: ApiService
) : IGameListRepository {

    override fun getGameList(): Flow<ApiResponse<List<Games>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameList()
            val gameList = response.results.toDomain()

            if (gameList.isNotEmpty()) {
                emit(ApiResponse.Success(gameList))
            }

            if (gameList.isEmpty()) {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            Log.e("GameListRepository/getGameList", e.toString())
            e.printStackTrace()
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}