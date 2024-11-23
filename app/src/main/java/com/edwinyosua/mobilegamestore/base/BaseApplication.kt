package com.edwinyosua.mobilegamestore.base

import android.app.Application
import com.edwinyosua.core.di.adapterModule
import com.edwinyosua.core.di.networkModules
import com.edwinyosua.core.di.repositoryModule
import com.edwinyosua.mobilegamestore.di.useCaseModule
import com.edwinyosua.mobilegamestore.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger(Level.NONE)
            modules(
                listOf(
                    networkModules,
                    viewModelModule,
                    adapterModule,
                    useCaseModule,
                    repositoryModule
                )

            )
        }
    }
}