package com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterPageDto
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel

fun CharacterDto.toEntity() = Character(
    id = this.id,
    name = this.name,
    imageUrl = this.image
)

fun CharacterPageDto.toEntity() = CharacterPage(
    pages = this.info.pages,
    characters = this.results.map { it.toEntity() }
)

fun CharacterModel.toEntity() = Character(
    id = this.id,
    name = this.name,
    imageUrl = this.imageUrl
)

fun Character.toModel() = CharacterModel(
    id = this.id,
    name = this.name,
    imageUrl = this.imageUrl
)