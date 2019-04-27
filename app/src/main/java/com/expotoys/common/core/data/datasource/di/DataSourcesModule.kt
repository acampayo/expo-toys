package com.expotoys.common.core.data.datasource.di

import com.expotoys.common.core.data.datasource.toy.ToysApiDataSource
import com.expotoys.common.core.data.datasource.toy.ToysDatasource
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val dataSourcesModule = Kodein.Module(name = "dataSourcesModule") {
    bind<ToysDatasource>() with singleton { ToysApiDataSource(instance()) }
}
