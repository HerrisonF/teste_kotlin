package com.teste_kotlin.network

import com.teste_kotlin.model.ResultAPI
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