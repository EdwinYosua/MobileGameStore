package com.edwinyosua.core.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val id: Int,
    val name: String,
    val rating: Double,
    val backgroundImg: String,
    val description: String,
    var isFavorite: Boolean
) : Parcelable
