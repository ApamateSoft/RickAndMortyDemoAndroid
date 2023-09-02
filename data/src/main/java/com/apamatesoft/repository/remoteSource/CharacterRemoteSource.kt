package com.apamatesoft.repository.remoteSource

import com.apamatesoft.domain.entity.CharacterPage

interface CharacterRemoteSource {
    suspend fun characterRequest(page: Int): CharacterPage
}