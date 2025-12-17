package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H\'J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\t"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/FavoriteDao;", "", "delete", "", "favoriteModel", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/model/FavoriteModel;", "getAll", "", "insert", "app_debug"})
public abstract interface FavoriteDao {
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel favoriteModel);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM favorites")
    public abstract java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel> getAll();
    
    @androidx.room.Delete
    public abstract void delete(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.FavoriteModel favoriteModel);
}