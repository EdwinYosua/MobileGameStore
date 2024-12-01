package com.edwinyosua.core.utils

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.domain.detail.model.GameDetail
import com.edwinyosua.core.domain.home.model.Games

object DataMapper {

    fun mapGameDataToEntity(games: Games, gamesDetail: GameDetail): GameEntity =
        GameEntity(
            id = games.id,
            name = games.name,
            rating = games.rating,
            backgroundImg = games.backgroundImage,
            description = gamesDetail.description,
            isFavorite = true
        )
}