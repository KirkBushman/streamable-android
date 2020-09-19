package com.kirkbushman.sampleapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.kirkbushman.streamable.StreamableClient
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class VideosTest {

    companion object {

        private val shortcodesArr = arrayOf(
            "wlia9l",
            "4z00y5",
            "spxw0o",
            "tysqmq",
            "mejxpp",
            "4osp8y",
            "wdxml",
            "jaxoi",
            "w5q5rm",
            "1sdk97",
            "8vov8x",
            "7s1uol",
            "9tdxbm"
        )
    }

    private val context by lazy { InstrumentationRegistry.getInstrumentation().targetContext.applicationContext }

    @Test
    fun testManualShortcodes() {

        var exception: Exception? = null

        try {

            val client = StreamableClient(true)

            shortcodesArr.forEach {

                val video = client.video(it)

                assertNotNull("[$it] Assert the returned object is not null", video)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
            exception = ex
        }

        assertNull("Assert there were no exceptions in the operations", exception)
    }
}
