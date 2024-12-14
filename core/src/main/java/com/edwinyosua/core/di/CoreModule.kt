package com.edwinyosua.core.di

import androidx.room.Room
import com.edwinyosua.core.data.local.LocalDataSources
import com.edwinyosua.core.data.local.room.GameDatabase
import com.edwinyosua.core.data.remote.network.ApiService
import com.edwinyosua.core.data.repository.GameDetailRepository
import com.edwinyosua.core.data.repository.GameFavoriteRepository
import com.edwinyosua.core.data.repository.GameListRepository
import com.edwinyosua.core.domain.detail.repository.IGameDetailRepository
import com.edwinyosua.core.domain.favorite.repository.IGameFavoriteRepository
import com.edwinyosua.core.domain.home.repository.IGameListRepository
import com.edwinyosua.core.ui.GameFavListAdapter
import com.edwinyosua.core.ui.GameListAdapter
import com.edwinyosua.core.utils.AppExecutors
import com.edwinyosua.core.utils.ConstVal
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataBaseModule = module {
    factory { get<GameDatabase>().gameDao() }
    single {
        Room.databaseBuilder(
            androidContext(),
            GameDatabase::class.java, "GameTable.db"
        ).fallbackToDestructiveMigration().build()
    }
}

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
    factory { GameFavListAdapter() }
}

val repositoryModule = module {
    single<IGameListRepository> { GameListRepository(get()) }
    single<IGameDetailRepository> { GameDetailRepository(get(), get(), get()) }
    single<IGameFavoriteRepository> { GameFavoriteRepository(get()) }
    single { LocalDataSources(get()) }
    factory { AppExecutors() }
}