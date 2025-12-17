package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/di/DataSourceModule;", "", "()V", "bindCharacterLocalSource", "Lcom/apamatesoft/repository/localSource/CharacterLocalSource;", "imp", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/repository/character/CharacterLocalSourceImp;", "bindCharacterRemoteSource", "Lcom/apamatesoft/repository/remoteSource/CharacterRemoteSource;", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/repository/character/CharacterRemoteSourceImp;", "bindFavoriteLocalSource", "Lcom/apamatesoft/repository/localSource/FavoriteLocalSource;", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/repository/faviorite/FavoriteLocalSourceImp;", "app_debug"})
@dagger.Module
public abstract class DataSourceModule {
    
    public DataSourceModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Binds
    public abstract com.apamatesoft.repository.remoteSource.CharacterRemoteSource bindCharacterRemoteSource(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterRemoteSourceImp imp);
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Binds
    public abstract com.apamatesoft.repository.localSource.CharacterLocalSource bindCharacterLocalSource(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterLocalSourceImp imp);
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Binds
    public abstract com.apamatesoft.repository.localSource.FavoriteLocalSource bindFavoriteLocalSource(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite.FavoriteLocalSourceImp imp);
}