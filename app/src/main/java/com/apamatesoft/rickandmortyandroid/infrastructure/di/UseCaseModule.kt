package com.apamatesoft.rickandmortyandroid.infrastructure.di

import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.usecase.CharacterRequestCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun providerCharacterRequestCase(
        characterRepo: CharacterRepository
    ): CharacterRequestCase = CharacterRequestCase(
        characterRepo = characterRepo
    )
    
}