package com.expotoys.application

import android.app.Application
import app.komuti.core.di.coreComponent
import com.expotoys.common.core.di.setApplicationContext
import com.expotoys.threading.APPLICATION_BG
import com.expotoys.threading.APPLICATION_MAIN
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newFixedThreadPoolContext
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class ExpoToysApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        extend(coreComponent)
    }

    override fun onCreate() {
        super.onCreate()
        setApplicationContext()
        setupThreadingContexts()
    }

    private fun setupThreadingContexts() {
        APPLICATION_MAIN = Dispatchers.Main
        APPLICATION_BG = newFixedThreadPoolContext(
            2 * Runtime.getRuntime().availableProcessors(),
            "bg"
        ) + CoroutineExceptionHandler { _, error -> throw error }

    }
}
