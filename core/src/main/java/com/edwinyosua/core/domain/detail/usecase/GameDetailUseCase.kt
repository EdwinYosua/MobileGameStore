package com.edwinyosua.core.domain.detail.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface GameDetailUseCase {
    fun getGameDetail(gameId: String): Flow<ApiResponse<GameDetail>>
}