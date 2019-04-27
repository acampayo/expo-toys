package com.expotoys.application

import android.app.Application
import app.komuti.core.di.coreComponent
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class ExpoToysApplication: Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        extend(coreComponent)
    }
}
