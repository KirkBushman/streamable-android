package com.kirkbushman.streamable.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class File(

    @Json(name = "status")
    val status: Int?,

    @Json(name = "url")
    val url: String?,

    @Json(name = "framerate")
    val framerate: Float,

    @Json(name = "width")
    val width: Int,

    @Json(name = "height")
    val height: Int,

    @Json(name = "bitrate")
    val bitrate: Long,

    @Json(name = "size")
    val size: Long,

    @Json(name = "duration")
    val duration: Float

) : Parcelable
