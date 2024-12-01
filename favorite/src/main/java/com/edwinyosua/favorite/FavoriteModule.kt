package com.edwinyosua.favorite

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module


val favoriteModule = module {
    viewModel { FavoriteViewModel(get()) }
}