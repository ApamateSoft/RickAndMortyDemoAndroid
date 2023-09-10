package com.apamatesoft.rickandmortyandroid.infrastructure.di

import com.apamatesoft.repository.CharacterRepository
import com.apamatesoft.repository.FavoriteRepository
import com.apamatesoft.usecase.AddFavoriteCase
import com.apamatesoft.usecase.CharacterRequestCase
import com.apamatesoft.usecase.GetAllFavoritesCase
import com.apamatesoft.usecase.RemoveFavoriteCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun providerCharacterRequestCase(
        characterRepo: CharacterRepository
    ): CharacterRequestCase = CharacterRequestCase(
        characterRepo = characterRepo
    )

    @Singleton
    @Provides
    fun providerAddFavoriteCase(
        favoriteRepository: FavoriteRepository
    ): AddFavoriteCase = AddFavoriteCase(favoriteRepository)

    @Singleton
    @Provides
    fun providerRemoveFavoriteCase(
        favoriteRepository: FavoriteRepository
    ): RemoveFavoriteCase = RemoveFavoriteCase(favoriteRepository)

    @Singleton
    @Provides
    fun providerGetAllFavoritesCase(
        favoriteRepository: FavoriteRepository
    ): GetAllFavoritesCase = GetAllFavoritesCase(favoriteRepository)

}