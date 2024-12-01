package com.edwinyosua.mobilegamestore.di

import com.edwinyosua.core.domain.detail.usecase.GameDetailInteractor
import com.edwinyosua.core.domain.detail.usecase.GameDetailUseCase
import com.edwinyosua.core.domain.favorite.GameFavoriteInteractor
import com.edwinyosua.core.domain.favorite.GameFavoriteUseCase
import com.edwinyosua.core.domain.home.usecase.GameInteractor
import com.edwinyosua.core.domain.home.usecase.GameUseCase
import com.edwinyosua.mobilegamestore.ui.detail.DetailViewModel
import com.edwinyosua.mobilegamestore.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<GameUseCase> { GameInteractor(get()) }
    factory<GameDetailUseCase> { GameDetailInteractor(get()) }
    factory<GameFavoriteUseCase> { GameFavoriteInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}

