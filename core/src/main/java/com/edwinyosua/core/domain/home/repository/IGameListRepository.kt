package com.edwinyosua.core.domain.home.repository

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.home.model.GamesList
import kotlinx.coroutines.flow.Flow

interface IGameListRepository {

    fun getGameList(): Flow<ApiResponse<List<GamesList>>>
}