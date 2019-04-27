package com.expotoys.common.core.data.datasource.toy

import com.expotoys.common.api.toys.ToysApi
import com.expotoys.common.core.domain.model.Toy
import org.funktionale.tries.Try

class ToysApiDataSource(
    private val api: ToysApi
) : ToysDatasource {
    override fun getToys(): Try<List<Toy>> = Try {
        api.getToys()
    }
}
