package com.edwinyosua.core.domain.favorite

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameListFavorite(
    val id: Int?,
    val name: String,
    val rating: Double,
    val backgroundImg: String,
    val description: String,
    val isFavorite: Boolean
) : Parcelable
