package com.edwinyosua.core.utils

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.home.model.Games

object DataMapper {

    fun mapGameDataToEntity(gameData: Games, gameDescription: GameDescription): GameEntity =
        GameEntity(
            id = gameData.id,
            name = gameData.name,
            rating = gameData.rating,
            backgroundImg = gameData.backgroundImage,
            description = gameDescription.description,
            isFavorite = false
        )
}