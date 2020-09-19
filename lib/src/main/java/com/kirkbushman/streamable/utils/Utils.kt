package com.kirkbushman.streamable.utils

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Utils {

    const val URL_STREAMABLE = "https://api.streamable.com"

    fun buildRetrofit(logging: Boolean): Retrofit {

        val moshi = Moshi.Builder().build()
        val moshiFactory = MoshiConverterFactory.create(moshi)

        val httpClient = if (logging) {

            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            OkHttpClient
                .Builder()
                .addInterceptor(logger)
                .build()
        } else {

            OkHttpClient
                .Builder()
                .build()
        }

        return Retrofit.Builder()
            .baseUrl(URL_STREAMABLE)
            .addConverterFactory(moshiFactory)
            .client(httpClient)
            .build()
    }
}