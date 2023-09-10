package com.apamatesoft.rickandmortyandroid.infrastructure.di

import android.content.Context
import androidx.room.Room
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalStorageModule {

    @Singleton
    @Provides
    fun providerDatabase(
        @ApplicationContext context: Context
    ): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "local_storage"
    ).build()

    @Singleton
    @Provides
    fun provideCharacterDao(db: AppDatabase): CharacterDao = db.getCharacterDao()

    @Singleton
    @Provides
    fun provideFavoriteDao(db: AppDatabase): FavoriteDao = db.getFavoriteDao()

}