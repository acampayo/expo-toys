package com.expotoys.common.data.repository.toy

import com.expotoys.common.core.domain.model.Toy
import com.expotoys.common.data.datasource.toy.ToysDatasource
import org.funktionale.tries.Try

internal class ToysRepositoryImpl(
    private val dataSource: ToysDatasource
) : ToysRepository {
    override fun getToys(): Try<List<Toy>> = dataSource.getToys()
}
