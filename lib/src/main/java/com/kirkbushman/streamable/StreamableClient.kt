package com.kirkbushman.streamable

import com.kirkbushman.streamable.models.Video
import com.kirkbushman.streamable.utils.Utils.buildRetrofit
import retrofit2.Retrofit

class StreamableClient(logging: Boolean) {

    companion object {

        @Volatile
        private var retrofit: Retrofit? = null
        @Volatile
        private var api: StreamableApi? = null

        @JvmStatic
        @Synchronized
        fun getRetrofit(logging: Boolean = false): Retrofit {

            if (retrofit == null) {

                synchronized(this) {

                    retrofit = buildRetrofit(logging)
                }
            }

            return retrofit!!
        }

        @JvmStatic
        @Synchronized
        fun getApi(logging: Boolean = false): StreamableApi {

            if (api == null) {

                synchronized(this) {

                    api = getRetrofit(logging).create(StreamableApi::class.java)
                }
            }

            return api!!
        }
    }

    private val api by lazy { getApi(logging) }

    fun video(shortcode: String): Video? {

        val req = api.video(shortcode)
        val res = req.execute()

        if (!res.isSuccessful) {
            return null
        }

        return res.body()
    }
}
