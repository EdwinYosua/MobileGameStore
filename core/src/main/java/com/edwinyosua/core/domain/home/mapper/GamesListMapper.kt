package com.edwinyosua.core.domain.home.mapper

import com.edwinyosua.core.data.remote.response.GameListResponse
import com.edwinyosua.core.domain.home.model.GamesList

fun List<GameListResponse>.toDomain(): List<GamesList> =
    this.map {
        GamesList(
            id = it.id,
            name = it.name,
            rating = it.rating,
            backgroundImage = it.backgroundImage,
        )
    }