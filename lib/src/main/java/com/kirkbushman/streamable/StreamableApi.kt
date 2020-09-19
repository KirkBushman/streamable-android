package com.kirkbushman.streamable

import com.kirkbushman.streamable.models.Video
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface StreamableApi {

    @GET("/videos/{shortcode}")
    fun video(
        @Path("shortcode") shortcode: String
    ): Call<Video>
}
