package com.edwinyosua.core.domain.home.mapper

import com.edwinyosua.core.data.remote.response.GameListResponse
import com.edwinyosua.core.domain.home.model.Games

fun List<GameListResponse>.toDomain(): List<Games> =
    this.map {
        Games(
            id = it.id,
            name = it.name,
            rating = it.rating,
            backgroundImage = it.backgroundImage,
        )
    }