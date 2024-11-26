package com.edwinyosua.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class RawgApiResponse(

    @field:SerializedName("results")
    val results: List<GameListResponse>,
)

