package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.Character
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.entity.CharacterEntity
import javax.inject.Inject

class CharacterLocalSourceImp @Inject constructor(
    private val dao: CharacterDao
): CharacterLocalSource {

    override suspend fun saveCharacters(characters: List<Character>) {
        characters.forEach {

            val entity = CharacterEntity(
                id = it.id,
                name = it.name,
                imageUrl = it.imageUrl
            )

            dao.insert(entity)

        }

    }

    override suspend fun loadCharacters(): List<Character> {
        val entities = dao.getAll()
        return entities.map { Character(
            id = it.id,
            name = it.name,
            imageUrl = it.imageUrl
        ) }
    }

}