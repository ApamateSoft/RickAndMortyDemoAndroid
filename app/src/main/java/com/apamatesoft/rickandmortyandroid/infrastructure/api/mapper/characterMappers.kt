package com.apamatesoft.rickandmortyandroid.infrastructure.api.mapper

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto
import com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterPageDto

fun CharacterPageDto.toCharacterPage(): CharacterPage {
    return CharacterPage(
        pages = this.info.pages,
        characters = this.results.map { it.toCharacter() }
    )
}

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = this.id,
        name = this.name,
        imageUrl = this.image
    )
}