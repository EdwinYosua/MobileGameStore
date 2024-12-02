package com.edwinyosua.mobilegamestore.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.detail.usecase.GameDetailUseCase
import com.edwinyosua.core.domain.home.model.Games
import kotlinx.coroutines.launch

class DetailViewModel(private val gameRepo: GameDetailUseCase) : ViewModel() {

//    private val _gameDescription = MutableLiveData<ApiResponse<GameDescription>>()
//    val gameDescription: LiveData<ApiResponse<GameDescription>> = _gameDescription

    fun getDetail(gameId: Int): LiveData<GameEntity> = gameRepo.getGameDetail(gameId).asLiveData()

    fun getDescription(gameId: Int) = gameRepo.getGameDescription(gameId).asLiveData()

    fun insertGameDataToLocal(game: Games, gameDesc: GameDescription) =
        viewModelScope.launch { gameRepo.insertGameData(game, gameDesc) }


}