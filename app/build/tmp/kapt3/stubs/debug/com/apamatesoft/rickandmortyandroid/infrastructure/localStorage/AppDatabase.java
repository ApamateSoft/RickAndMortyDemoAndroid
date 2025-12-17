package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage;

import java.lang.System;

@androidx.room.Database(entities = {com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel.class, com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel.class}, version = 1)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getCharacterDao", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/CharacterDao;", "getFavoriteDao", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/FavoriteDao;", "app_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    public AppDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao getCharacterDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao getFavoriteDao();
}