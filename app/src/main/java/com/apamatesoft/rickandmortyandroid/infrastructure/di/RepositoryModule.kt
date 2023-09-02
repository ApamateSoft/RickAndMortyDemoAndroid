package com.apamatesoft.rickandmortyandroid.infrastructure.di

import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providerCharacterRepository(
        local: CharacterLocalSource,
        remote: CharacterRemoteSource
    ) = CharacterRepository(remote, local)

}