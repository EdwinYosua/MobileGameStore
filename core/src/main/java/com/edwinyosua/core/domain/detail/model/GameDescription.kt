package com.edwinyosua.core.domain.detail.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDescription(
    val description: String
) : Parcelable
