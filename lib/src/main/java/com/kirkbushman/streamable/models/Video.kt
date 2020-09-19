package com.kirkbushman.streamable.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class Video(

    @Json(name = "status")
    val status: Int,

    @Json(name = "percent")
    val percent: Int,

    @Json(name = "url")
    val url: String,

    @Json(name = "embed_code")
    val embedCode: String,

    @Json(name = "files")
    val files: VideoFiles,

    @Json(name = "thumbnail_url")
    val thumbnailUrl: String,

    @Json(name = "title")
    val title: String,

    @Json(name = "message")
    val message: String?,

    @Json(name = "source")
    val source: String?

) : Parcelable
