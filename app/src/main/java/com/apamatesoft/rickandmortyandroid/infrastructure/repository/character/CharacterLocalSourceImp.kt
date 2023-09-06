package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.repository.localSource.CharacterLocalSource
import javax.inject.Inject

class CharacterLocalSourceImp @Inject constructor(): CharacterLocalSource {

    private var characters: List<Character> = emptyList()

    override suspend fun saveCharacters(characters: List<Character>) {
        this.characters = characters
    }

    override suspend fun loadCharacters(): List<Character> {
        return characters
    }

}