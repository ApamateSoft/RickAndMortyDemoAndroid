package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u00a8\u0006\r"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/di/RepositoryModule;", "", "()V", "providerCharacterRepository", "Lcom/apamatesoft/repository/CharacterRepository;", "local", "Lcom/apamatesoft/repository/localSource/CharacterLocalSource;", "remote", "Lcom/apamatesoft/repository/remoteSource/CharacterRemoteSource;", "providerFavoriteRepository", "Lcom/apamatesoft/repository/FavoriteRepository;", "localSource", "Lcom/apamatesoft/repository/localSource/FavoriteLocalSource;", "app_debug"})
@dagger.Module
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull
    public static final com.apamatesoft.rickandmortyandroid.infrastructure.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.apamatesoft.repository.CharacterRepository providerCharacterRepository(@org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.localSource.CharacterLocalSource local, @org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.remoteSource.CharacterRemoteSource remote) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.apamatesoft.repository.FavoriteRepository providerFavoriteRepository(@org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.localSource.FavoriteLocalSource localSource) {
        return null;
    }
}