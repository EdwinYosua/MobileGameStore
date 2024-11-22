package com.edwinyosua.core.data.repository

import android.util.Log
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.data.remote.network.ResultsItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameListRepository(private val apiService: ApiService) {

    fun getGameList(): Flow<ApiResponse<List<ResultsItem>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameList()
            val gameList = response.results
            if (gameList.isNotEmpty()) {
                emit(ApiResponse.Success(gameList))
            }
            if (gameList.isEmpty()) {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ApiResponse.Error(e.message.toString()))
            Log.e("GameListRepository", e.toString())
        }
    }.flowOn(Dispatchers.IO)
}