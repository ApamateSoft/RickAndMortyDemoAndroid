package com.apamatesoft.repository.localSource

import com.apamatesoft.domain.entity.Character

interface CharacterLocalSource {
    suspend fun saveCharacters(characters: List<Character>)

    suspend fun loadCharacters(): List<Character>

    suspend fun clear()

}