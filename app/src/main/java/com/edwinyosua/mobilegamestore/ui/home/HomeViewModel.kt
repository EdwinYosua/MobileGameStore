package com.edwinyosua.mobilegamestore.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edwinyosua.core.domain.home.usecase.GameListUseCase

class HomeViewModel(gameRepo: GameListUseCase) : ViewModel() {

    val gameList = gameRepo.getGameList().asLiveData()

}