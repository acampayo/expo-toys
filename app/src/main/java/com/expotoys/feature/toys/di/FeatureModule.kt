package com.expotoys.feature.toys.di

import com.expotoys.feature.toys.presentation.ToysPresenter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

internal val featureModule = Kodein.Module(name = "toysFeatureModule") {
    bind<ToysPresenter>() with provider { ToysPresenter(instance()) }
}
