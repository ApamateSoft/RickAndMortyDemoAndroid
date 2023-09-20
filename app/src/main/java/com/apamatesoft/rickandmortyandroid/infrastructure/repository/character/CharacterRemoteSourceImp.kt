package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.mapper.toEntity
import javax.inject.Inject

class CharacterRemoteSourceImp @Inject constructor(
    private val characterApi: CharacterApi
): CharacterRemoteSource {

    override suspend fun characterRequest(page: Int): CharacterPage {
        val dto = characterApi.characterRequest(page)
        return dto.toEntity()
    }

}