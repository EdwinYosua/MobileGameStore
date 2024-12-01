package com.edwinyosua.core.domain.favorite

import android.os.Parcelable
import com.edwinyosua.core.utils.ConstVal
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameListFavoriteData(
    val id: Int? = null,
    val name: String,
    val rating: Double,
    val backgroundImg: String,
    val description: String = ConstVal.emptyString,
    val isFavorite: Boolean = false
) : Parcelable
//
//object GameListFavoriteMapper {
//
//    fun mapAllDataToGameListFavoriteData(
//        games: List<Games>,
//        gamesDetail: List<GameDetail>
//    ): List<GameListFavoriteData> {
//
//        return games.map { game ->
//            GameListFavoriteData(
//                id = game.id,
//                name = game.name,
//                rating = game.rating,
//                backgroundImg = game.backgroundImage,
//                description = gamesDetail.first { gamesDetail.isNotEmpty() }.description,
//                isFavorite = false
//            )
//        }
//    }
//
//
//}