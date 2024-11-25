package com.edwinyosua.core.di

import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.data.remote.detail.GameDetailRepository
import com.edwinyosua.core.data.remote.home.GameListRepository
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.home.repository.IGameListRepository
import com.edwinyosua.core.ui.GameListAdapter
import com.edwinyosua.core.utils.ConstVal
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModules = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConstVal.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val adapterModule = module {
    factory { GameListAdapter() }
}

val repositoryModule = module {
    single<IGameListRepository> { GameListRepository(get()) }
    single<IGameDetailRepository> { GameDetailRepository(get()) }
}