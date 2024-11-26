package com.edwinyosua.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class GameListResponse(

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("rating")
    val rating: Double,

    @field:SerializedName("background_image")
    val backgroundImage: String,


    )