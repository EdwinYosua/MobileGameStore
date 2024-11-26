package com.edwinyosua.core.domain.detail.mapper

import com.edwinyosua.core.data.remote.response.GameDetailResponse
import com.edwinyosua.core.domain.detail.model.GameDetail

fun GameDetailResponse.toDomain(): GameDetail =
    GameDetail(
        description = this.descriptionRaw
    )