package com.edwinyosua.core.domain.detail.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDetail
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.home.model.Games
import kotlinx.coroutines.flow.Flow

class GameDetailInteractor(private val gameRepo: IGameDetailRepository) : GameDetailUseCase {
    override fun getGameDetail(gameId: String): Flow<ApiResponse<GameDetail>> =
        gameRepo.getGameDetail(gameId)

    override suspend fun insertFavGame(game: Games, gameDescription: GameDetail) =
        gameRepo.insertFavGame(game, gameDescription)
}