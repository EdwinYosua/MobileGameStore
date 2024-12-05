package com.edwinyosua.core.domain.home.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.home.model.GamesList
import kotlinx.coroutines.flow.Flow

interface GameListUseCase {
    fun getGameList(): Flow<ApiResponse<List<GamesList>>>
}