package app.komuti.core.di

import com.expotoys.common.api.di.apiModule
import com.expotoys.common.api.toys.di.toysApiModule
import com.expotoys.common.core.data.datasource.di.dataSourcesModule
import com.expotoys.common.core.data.repository.di.repositoryModule
import com.expotoys.common.core.di.coreModule
import org.kodein.di.Kodein

val coreComponent = Kodein {
    import(repositoryModule)
    import(dataSourcesModule)
    import(toysApiModule)
    import(apiModule)
    import(coreModule)
}
