package com.edwinyosua.core.data.remote.network

import com.edwinyosua.core.utils.ConstVal
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("games")
    suspend fun getGameList(
        @Query("page_size") pageSize: Int = 10,
        @Query("key") key: String = ConstVal.API_KEY
    ): RawgApiResponse

}