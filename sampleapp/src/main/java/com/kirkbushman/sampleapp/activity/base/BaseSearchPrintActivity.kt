package com.kirkbushman.sampleapp.activity.base

import android.os.Bundle
import com.kirkbushman.sampleapp.R
import com.kirkbushman.sampleapp.StreamableApplication
import com.kirkbushman.sampleapp.utils.doAsync
import com.kirkbushman.streamable.StreamableClient
import kotlinx.android.synthetic.main.activity_search_print.*

abstract class BaseSearchPrintActivity<T> : BaseActivity(R.layout.activity_search_print) {

    private val client by lazy { StreamableApplication.instance?.client }

    private var item: T? = null

    abstract fun fetchItem(client: StreamableClient, query: String): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }

        search_bttn.setOnClickListener {

            val query = query.text.trim().toString()

            doAsync(
                doWork = { item = fetchItem(client!!, query) },
                onPost = { obj_text.text = item.toString() }
            )
        }
    }
}
