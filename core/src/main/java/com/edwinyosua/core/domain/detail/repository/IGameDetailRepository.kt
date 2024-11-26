package com.edwinyosua.core.domain.detail.repository

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface IGameDetailRepository {
    fun getGameDetail(gameId: String): Flow<ApiResponse<GameDetail>>
}