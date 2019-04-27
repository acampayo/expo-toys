package com.expotoys.common.data.datasource.toy

import com.expotoys.common.core.domain.model.Toy
import org.funktionale.tries.Try

interface ToysDatasource {
    fun getToys(): Try<List<Toy>>
}
