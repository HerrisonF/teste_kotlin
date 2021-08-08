package com.teste_br_mall.network

import com.teste_br_mall.model.ResultAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyAPI {

    @GET("/api/character")
    suspend fun getCharacterAPI (
        @Query("page")
        page: Int,
        @Query("id")
        id: Int? = null,
    ) : Response<ResultAPI>

}