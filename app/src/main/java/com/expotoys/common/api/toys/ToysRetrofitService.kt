package com.expotoys.common.api.toys

import com.expotoys.common.core.domain.model.Toy
import retrofit2.Call
import retrofit2.http.GET

interface ToysRetrofitService {
    @GET
    fun getToys(): Call<List<Toy>>
}