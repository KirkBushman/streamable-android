package com.kirkbushman.sampleapp.activity

import android.content.Context
import android.content.Intent
import com.kirkbushman.sampleapp.activity.base.BaseSearchPrintActivity
import com.kirkbushman.streamable.StreamableClient
import com.kirkbushman.streamable.models.Video

class VideoActivity : BaseSearchPrintActivity<Video?>() {

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, VideoActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun fetchItem(client: StreamableClient, query: String): Video? {

        return client.video(query)
    }
}
