package com.apamatesoft.repository

import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.domain.entity.Character
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource

class CharacterRepository(
    private val remoteSource: CharacterRemoteSource,
    private val localSource: CharacterLocalSource
) {

    suspend fun characterRequest(page: Int): CharacterPage = remoteSource.characterRequest(page)

    suspend fun saveCharacters(characters: List<Character>) = localSource.saveCharacters(characters)

    suspend fun loadCharacters(): List<Character> = localSource.loadCharacters()

}