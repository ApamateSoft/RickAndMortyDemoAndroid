package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper.toEntity
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper.toModel
import javax.inject.Inject

class CharacterLocalSourceImp @Inject constructor(
    private val dao: CharacterDao
): CharacterLocalSource {

    override suspend fun saveCharacters(characters: List<Character>) {
        characters.forEach {
            dao.insert(it.toModel())
        }
    }

    override suspend fun loadCharacters(): List<Character> {
        val entities = dao.getAll()
        return entities.map { it.toEntity() }
    }

}