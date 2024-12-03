package com.edwinyosua.core.domain.detail.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.Games
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.home.model.GamesList
import kotlinx.coroutines.flow.Flow

class GameDetailInteractor(private val gameRepo: IGameDetailRepository) : GameDetailUseCase {


    override fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>> =
        gameRepo.getGameDescription(gameId)

    override fun setFavorite(gameData: Games, newState: Boolean) =
        gameRepo.setFavorite(gameData, newState)

    override fun getGameDetail(gameId: Int): Flow<Games> = gameRepo.getGameDetail(gameId)


    override suspend fun insertGameData(game: GamesList, gameDescription: GameDescription) =
        gameRepo.insertGameData(game, gameDescription)


}