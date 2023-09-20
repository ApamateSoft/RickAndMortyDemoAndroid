package com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper

import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel

fun Int.toModel() = FavoriteModel(this)

fun FavoriteModel.toEntity() = this.id