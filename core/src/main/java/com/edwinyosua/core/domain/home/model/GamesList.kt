package com.edwinyosua.core.domain.home.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesList(
    val id: Int,
    val name: String,
    val rating: Double,
    val backgroundImage: String,
) : Parcelable
