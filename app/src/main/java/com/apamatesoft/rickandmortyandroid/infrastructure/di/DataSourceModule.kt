package com.apamatesoft.rickandmortyandroid.infrastructure.di

import com.apamatesoft.repository.localSource.CharacterLocalSource
import com.apamatesoft.repository.localSource.FavoriteLocalSource
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterLocalSourceImp
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterRemoteSourceImp
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite.FavoriteLocalSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindCharacterRemoteSource(imp: CharacterRemoteSourceImp): CharacterRemoteSource

    @Binds
    @Singleton
    abstract fun bindCharacterLocalSource(imp: CharacterLocalSourceImp): CharacterLocalSource

    @Binds
    @Singleton
    abstract fun bindFavoriteLocalSource(imp: FavoriteLocalSourceImp): FavoriteLocalSource

}