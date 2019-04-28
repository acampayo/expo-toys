package com.expotoys.common.core.di

import android.app.Application
import android.content.Context
import com.expotoys.common.exceptions.ContextException
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import java.io.File

val coreModule = Kodein.Module(name = "coreModule") {
    bind<Application>() with singleton {
        APPLICATION_CONTEXT ?: throw ContextException()
    }
    bind<File>(tag = "CacheFolder") with singleton {
        val context: Context = instance()
        context.cacheDir
    }
}

private var APPLICATION_CONTEXT: Application? = null

fun Application.setApplicationContext() {
    APPLICATION_CONTEXT = this
}
