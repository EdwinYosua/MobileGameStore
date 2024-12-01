package com.edwinyosua.core.domain.detail.model

import android.os.Parcelable
import com.edwinyosua.core.utils.ConstVal
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameDetail(
    val description: String? = ConstVal.emptyString
) : Parcelable
