package com.edwinyosua.core.domain.home.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.response.GameDetailResponse
import com.edwinyosua.core.domain.home.model.Games
import kotlinx.coroutines.flow.Flow

interface GameUseCase {
    fun getGameList(): Flow<ApiResponse<List<Games>>>
}