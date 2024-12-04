package com.edwinyosua.core.domain.detail.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.Games
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.home.model.GamesList
import kotlinx.coroutines.flow.Flow

interface GameDetailUseCase {


    fun getGameDetail(gameId: Int): Flow<Games>

    fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>>

    fun setFavorite(gameData: Games, newState: Boolean)

    suspend fun insertGameData(game: GamesList, gameDescription: GameDescription)


}