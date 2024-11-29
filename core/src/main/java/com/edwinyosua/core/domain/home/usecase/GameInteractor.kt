package com.edwinyosua.core.domain.home.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.response.GameDetailResponse
import com.edwinyosua.core.domain.home.model.Games
import com.edwinyosua.core.domain.home.repository.IGameListRepository
import kotlinx.coroutines.flow.Flow

class GameInteractor(private val gameRepository: IGameListRepository) : GameUseCase {
    override fun getGameList(): Flow<ApiResponse<List<Games>>> = gameRepository.getGameList()

}