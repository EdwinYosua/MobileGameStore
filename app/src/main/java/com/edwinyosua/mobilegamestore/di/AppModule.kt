package com.edwinyosua.mobilegamestore.di

import com.edwinyosua.core.data.repository.GameListRepository
import com.edwinyosua.mobilegamestore.ui.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    factory {
        GameListRepository(get())
    }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}

