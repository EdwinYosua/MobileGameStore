package com.edwinyosua.core.domain.detail.mapper

import com.edwinyosua.core.data.remote.response.GameDetailResponse
import com.edwinyosua.core.domain.detail.model.GameDescription

fun GameDetailResponse.toDomain(): GameDescription =
    GameDescription(
        description = this.descriptionRaw
    )