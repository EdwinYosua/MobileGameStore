package com.edwinyosua.core.utils

import com.edwinyosua.core.data.local.entities.GameEntity
import com.edwinyosua.core.domain.Games
import com.edwinyosua.core.domain.detail.model.GameDescription
import com.edwinyosua.core.domain.favorite.GameListFavorite
import com.edwinyosua.core.domain.home.model.GamesList

object DataMapper {

    fun mapGameDataToEntity(gameData: GamesList, gameDescription: GameDescription): GameEntity =
        GameEntity(
            id = gameData.id,
            name = gameData.name,
            rating = gameData.rating,
            backgroundImg = gameData.backgroundImage,
            description = gameDescription.description,
            isFavorite = false
        )

    fun mapFavEntityToFavDomain(input: List<GameEntity>): List<GameListFavorite> =
        input.map { favList ->
            GameListFavorite(
                id = favList.id,
                name = favList.name,
                rating = favList.rating,
                backgroundImg = favList.backgroundImg,
                description = favList.description,
                isFavorite = favList.isFavorite
            )
        }

    fun mapEntityToDomain(input: GameEntity): Games =
        Games(
            id = input.id,
            name = input.name,
            rating = input.rating,
            backgroundImg = input.backgroundImg,
            description = input.description,
            isFavorite = input.isFavorite
        )

    fun mapDomainToEntity(games: Games): GameEntity =
        GameEntity(
            id = games.id,
            name = games.name,
            rating = games.rating,
            backgroundImg = games.backgroundImg,
            description = games.description,
            isFavorite = games.isFavorite
        )

    fun mapEntityListToDomainList(input: List<GameEntity>): List<Games> =
        input.map { gameList ->
            Games(
                id = gameList.id,
                name = gameList.name,
                rating = gameList.rating,
                backgroundImg = gameList.backgroundImg,
                description = gameList.description,
                isFavorite = gameList.isFavorite
            )
        }
}