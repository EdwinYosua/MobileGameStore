package com.edwinyosua.mobilegamestore.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.edwinyosua.core.data.repository.GameListRepository

class HomeViewModel(private val repo: GameListRepository) : ViewModel() {


    val gameList = repo.getGameList().asLiveData()


}