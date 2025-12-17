package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/di/UseCaseModule;", "", "()V", "providerAddFavoriteCase", "Lcom/apamatesoft/usecase/AddFavoriteCase;", "favoriteRepository", "Lcom/apamatesoft/repository/FavoriteRepository;", "providerCharacterRequestCase", "Lcom/apamatesoft/usecase/CharacterRequestCase;", "characterRepo", "Lcom/apamatesoft/repository/CharacterRepository;", "providerGetAllFavoritesCase", "Lcom/apamatesoft/usecase/GetAllFavoritesCase;", "providerRemoveFavoriteCase", "Lcom/apamatesoft/usecase/RemoveFavoriteCase;", "app_debug"})
@dagger.Module
public final class UseCaseModule {
    @org.jetbrains.annotations.NotNull
    public static final com.apamatesoft.rickandmortyandroid.infrastructure.di.UseCaseModule INSTANCE = null;
    
    private UseCaseModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.apamatesoft.usecase.CharacterRequestCase providerCharacterRequestCase(@org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.CharacterRepository characterRepo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.apamatesoft.usecase.AddFavoriteCase providerAddFavoriteCase(@org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.FavoriteRepository favoriteRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.apamatesoft.usecase.RemoveFavoriteCase providerRemoveFavoriteCase(@org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.FavoriteRepository favoriteRepository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.apamatesoft.usecase.GetAllFavoritesCase providerGetAllFavoritesCase(@org.jetbrains.annotations.NotNull
    com.apamatesoft.repository.FavoriteRepository favoriteRepository) {
        return null;
    }
}