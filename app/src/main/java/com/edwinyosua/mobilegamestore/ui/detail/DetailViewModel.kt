package com.edwinyosua.mobilegamestore.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edwinyosua.core.data.remote.network.ApiResponse
import com.edwinyosua.core.data.remote.response.GameDetailResponse
import com.edwinyosua.core.domain.home.usecase.GameUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private val gameRepo: GameUseCase) : ViewModel() {

    private val _gameDetail = MutableLiveData<ApiResponse<GameDetailResponse>>()
    val gameDetail: LiveData<ApiResponse<GameDetailResponse>> = _gameDetail

    fun getGameDetail(gameId: String = "") {
        viewModelScope.launch {
            gameRepo.getGameDetail(gameId).collect {
                _gameDetail.value = it
            }
        }
    }
}