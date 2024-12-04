package com.edwinyosua.core.data.repository

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.domain.home.mapper.toDomain
import com.edwinyosua.core.domain.home.model.GamesList
import com.edwinyosua.core.domain.home.repository.IGameListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GameListRepository(
    private val apiService: ApiService
) : IGameListRepository {

    override fun getGameList(): Flow<ApiResponse<List<GamesList>>> = flow {
        try {
            emit(ApiResponse.Loading)
            val response = apiService.getGameList()

//          MAP DATA FROM API TO DOMAIN
            val gameList = response.results.toDomain()

            if (gameList.isNotEmpty()) {
                emit(ApiResponse.Success(gameList))
            }

            if (gameList.isEmpty()) {
                emit(ApiResponse.Empty)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ApiResponse.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

}