package com.apamatesoft.repository.remoteSource

import com.apamatesoft.domain.entity.CharacterPage

interface CharacterRemoteSource {
    suspend fun requestCharacters(page: Int): CharacterPage
}