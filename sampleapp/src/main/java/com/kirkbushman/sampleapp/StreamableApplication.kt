package com.kirkbushman.sampleapp

import android.app.Application
import com.kirkbushman.streamable.StreamableClient

class StreamableApplication : Application() {

    companion object {

        private const val LOGGING = true

        var instance: StreamableApplication? = null
    }

    val client by lazy { StreamableClient(LOGGING) }

    override fun onCreate() {
        super.onCreate()

        instance = this
    }
}
