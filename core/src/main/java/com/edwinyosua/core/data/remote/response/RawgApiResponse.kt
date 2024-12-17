package com.edwinyosua.core.data.remote.response

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class RawgApiResponse(

    @field:SerializedName("results")
    val results: List<GameListResponse>,
)

