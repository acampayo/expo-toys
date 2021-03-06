package com.expotoys.common.core.data.repository.toy

import com.expotoys.common.core.domain.model.Toy
import org.funktionale.tries.Try

interface ToysRepository {
    fun getToys(): Try<List<Toy>>
}
