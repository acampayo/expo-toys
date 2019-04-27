package com.expotoys.common.api.toys

import com.expotoys.common.core.domain.model.Toy

interface ToysApi {
    fun getToys(): List<Toy>
}