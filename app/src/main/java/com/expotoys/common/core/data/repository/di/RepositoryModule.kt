package com.expotoys.common.core.data.repository.di

import com.expotoys.common.core.data.repository.toy.ToysRepository
import com.expotoys.common.core.data.repository.toy.ToysRepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

val repositoryModule = Kodein.Module(name = "repositoryModule") {
    bind<ToysRepository>() with provider { ToysRepositoryImpl(instance()) }
}
