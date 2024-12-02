package com.edwinyosua.core.domain.detail.usecase

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.home.model.Games
import kotlinx.coroutines.flow.Flow

interface GameDetailUseCase {



    fun getGameDetail(gameId: Int): Flow<GameEntity>

    fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>>

//    fun setFavorite(gameData: GameEntity, newState: Boolean)

    suspend fun insertGameData(game: Games, gameDescription: GameDescription)



}