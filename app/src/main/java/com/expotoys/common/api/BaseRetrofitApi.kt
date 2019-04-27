package com.expotoys.common.api

import com.expotoys.common.exceptions.NetworkException
import retrofit2.Call
import java.io.IOException

abstract class BaseRetrofitApi {
    inline fun <T> execute(f: () -> Call<T>): T {
        val body: T
        try {
            body = f().execute().body()!!
        } catch (error: IOException) {
            throw NetworkException("Unknown error")
        }
        return body
    }

    inline fun <T> executeVoid(f: () -> Call<T>) {
        try {
            f().execute()
        } catch (error: IOException) {
            throw NetworkException("Unknown error")
        }
    }
}
