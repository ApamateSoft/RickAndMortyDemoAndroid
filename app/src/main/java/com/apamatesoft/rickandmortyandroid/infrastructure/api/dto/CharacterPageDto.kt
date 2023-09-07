package com.apamatesoft.rickandmortyandroid.infrastructure.api.dto

import com.google.gson.annotations.SerializedName

data class CharacterPageDto(
    @SerializedName("info") val info: InfoDto,
    @SerializedName("results") val results: List<CharacterDto>
)

data class InfoDto(
    @SerializedName("pages") val pages: Int
)
