package com.edwinyosua.mobilegamestore.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.domain.detail.model.GameDetail
import com.edwinyosua.core.domain.detail.usecase.GameDetailUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val gameRepo: GameDetailUseCase) : ViewModel() {

    private val _gameDetail = MutableLiveData<ApiResponse<GameDetail>>()
    val gameDetail: LiveData<ApiResponse<GameDetail>> = _gameDetail

    fun getGameDetail(gameId: String = "") {
        viewModelScope.launch {
            gameRepo.getGameDetail(gameId).collect {
                _gameDetail.value = it
            }
        }
    }
}