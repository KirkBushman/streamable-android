package com.kirkbushman.streamable.models

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class VideoFiles(

    @Json(name = "mp4")
    val mp4: File,

    @Json(name = "mp4-mobile")
    val mp4Mobile: File?,

    @Json(name = "original")
    val original: File

) : Parcelable
