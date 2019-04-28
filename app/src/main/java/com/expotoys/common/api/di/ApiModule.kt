package com.expotoys.common.api.di

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Cache
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File

val apiModule = Kodein.Module(name = "apiModule") {
    val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MB

    val moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    fun buildRetrofit(baseUrl: String, httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(httpClient)
            .baseUrl(baseUrl)
            .build()
    }

    bind<Retrofit>() with singleton {
        val httpClient: OkHttpClient = instance()
        buildRetrofit("http://www.google.com", httpClient)
    }
    bind<Moshi>() with provider { moshi }
    bind<OkHttpClient>() with singleton {
        val cacheFolder: File = instance(tag = "CacheFolder")
        val cache = Cache(cacheFolder, CACHE_SIZE)
        val logging = HttpLoggingInterceptor()

        OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(logging)
            .build()
    }
}
