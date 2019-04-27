package com.expotoys.common.api.toys.di

import com.expotoys.common.api.toys.ToysApi
import com.expotoys.common.api.toys.ToysRetrofitApi
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

val toysApiModule = Kodein.Module(name = "toysApiModule") {
    bind<ToysApi>() with singleton { ToysRetrofitApi(instance()) }
}
