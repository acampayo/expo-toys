package com.expotoys.common.api.toys

import com.expotoys.common.api.BaseRetrofitApi
import com.expotoys.common.core.domain.model.Toy

class ToysRetrofitApi(private val toysService: ToysRetrofitService) : ToysApi,
    BaseRetrofitApi() {
    override fun getToys(): List<Toy> {
        return execute {
            toysService.getToys()
        }
    }
}