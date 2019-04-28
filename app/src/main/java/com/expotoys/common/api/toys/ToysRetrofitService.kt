package com.expotoys.common.api.toys

import com.expotoys.common.core.domain.model.Toy
import retrofit2.Call
import retrofit2.http.GET

interface ToysRetrofitService {
    @GET("5cc5ed4c2e00004e00594b57")
    fun getToys(): Call<List<Toy>>
}
