package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.repository.localSource.CharacterLocalSource
import javax.inject.Inject

class CharacterLocalSourceImp @Inject constructor(): CharacterLocalSource {
    override suspend fun saveCharacters(characters: List<Character>) {
        TODO("Not yet implemented")
    }

    override suspend fun loadCharacters(): List<Character> {
        TODO("Not yet implemented")
    }

}