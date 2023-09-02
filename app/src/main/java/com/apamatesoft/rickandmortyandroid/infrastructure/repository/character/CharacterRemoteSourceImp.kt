package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character

import com.apamatesoft.domain.entity.CharacterPage
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import javax.inject.Inject

class CharacterRemoteSourceImp @Inject constructor(): CharacterRemoteSource {
    override suspend fun characterRequest(page: Int): CharacterPage {
        TODO("Not yet implemented")
    }

}