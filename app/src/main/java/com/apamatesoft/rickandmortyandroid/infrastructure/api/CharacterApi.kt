package com.apamatesoft.rickandmortyandroid.infrastructure.api

import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterPageDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApi {

    @GET("/api/character")
    suspend fun characterRequest(@Query("page") page: Int): CharacterPageDto

}