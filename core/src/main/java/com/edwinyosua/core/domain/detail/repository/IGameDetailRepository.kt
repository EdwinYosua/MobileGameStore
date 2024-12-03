package com.edwinyosua.core.domain.detail.repository

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.Games
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.home.model.GamesList
import kotlinx.coroutines.flow.Flow

interface IGameDetailRepository {

    fun getGameDetail(gameId: Int): Flow<Games>

    fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>>

    fun setFavorite(gameData: Games, newState: Boolean)

    suspend fun insertGameData(game: GamesList, gameDescription: GameDescription)

}