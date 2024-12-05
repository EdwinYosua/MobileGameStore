package com.edwinyosua.core.domain.home.usecase

import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.home.model.GamesList
import com.edwinyosua.core.domain.home.repository.IGameListRepository
import kotlinx.coroutines.flow.Flow

class GameListListInteractor(private val gameRepository: IGameListRepository) : GameListUseCase {
    override fun getGameList(): Flow<ApiResponse<List<GamesList>>> = gameRepository.getGameList()

}