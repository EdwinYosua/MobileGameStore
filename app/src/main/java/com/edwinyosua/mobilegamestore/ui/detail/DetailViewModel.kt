package com.edwinyosua.mobilegamestore.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.edwinyosua.core.domain.Games
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.detail.usecase.GameDetailUseCase
import com.edwinyosua.core.domain.home.model.GamesList
import kotlinx.coroutines.launch

class DetailViewModel(private val gameRepo: GameDetailUseCase) : ViewModel() {


    private val _getGameDetail = MutableLiveData<Games>()
    val getGameDetail: LiveData<Games> by lazy { _getGameDetail }

    fun getDescription(gameId: Int) = gameRepo.getGameDescription(gameId).asLiveData()

    fun insertGameDataToLocal(game: GamesList, gameDesc: GameDescription) {
        viewModelScope.launch {
            gameRepo.insertGameData(game, gameDesc)

//          COLLECT GAME DATA BASE ON THEIR ID FROM LOCAL
            gameRepo.getGameDetail(game.id).collect {
                _getGameDetail.value = it
            }
        }
    }

    fun setFavorite(gameData: Games, newState: Boolean) {
        gameRepo.setFavorite(gameData, newState)
    }


}