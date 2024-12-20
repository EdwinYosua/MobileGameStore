package com.edwinyosua.core.utils

import android.os.Handler
import android.os.Looper
import androidx.annotation.VisibleForTesting

import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AppExecutors @VisibleForTesting constructor(
    private val diskIO: Executor,
    private val networkIO: Executor,
    private val mainThread: Executor
) {

    constructor() : this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(THREAD_COUNT),
        MainThreadExecutors()
    )

    fun diskIO(): Executor = diskIO


    private class MainThreadExecutors : Executor {
        private val mainThreadHandler = Handler(Looper.getMainLooper())

        override fun execute(cmd: Runnable) {
            mainThreadHandler.post(cmd)
        }
    }

    companion object {
        private const val THREAD_COUNT = 3
    }
}