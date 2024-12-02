package com.edwinyosua.core.domain.detail.usecase

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.home.model.Games
import kotlinx.coroutines.flow.Flow

class GameDetailInteractor(private val gameRepo: IGameDetailRepository) : GameDetailUseCase {


    override fun getGameDescription(gameId: Int): Flow<ApiResponse<GameDescription>> =
        gameRepo.getGameDescription(gameId)

//    override fun setFavorite(gameData: GameEntity, newState: Boolean) {}

    override fun getGameDetail(gameId: Int): Flow<GameEntity> = gameRepo.getGameDetail(gameId)


    override suspend fun insertGameData(game: Games, gameDescription: GameDescription) =
        gameRepo.insertGameData(game, gameDescription)



}