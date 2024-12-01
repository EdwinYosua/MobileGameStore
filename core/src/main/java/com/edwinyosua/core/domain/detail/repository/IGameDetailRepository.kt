package com.edwinyosua.core.domain.detail.repository

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDetail
import com.edwinyosua.core.domain.home.model.Games
import kotlinx.coroutines.flow.Flow

interface IGameDetailRepository {
    fun getGameDetail(gameId: String): Flow<ApiResponse<GameDetail>>

    suspend fun insertFavGame(game: Games, gameDescription: GameDetail)
}