package com.expotoys.feature.toys.di

import app.komuti.core.di.coreComponent
import org.kodein.di.Kodein

internal val featureComponent = Kodein {
    extend(coreComponent)
    import(featureModule)
}
