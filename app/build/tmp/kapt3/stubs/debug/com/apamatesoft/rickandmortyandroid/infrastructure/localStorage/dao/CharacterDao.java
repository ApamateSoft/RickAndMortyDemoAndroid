package com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao;

import java.lang.System;

@androidx.room.Dao
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\'J\b\u0010\b\u001a\u00020\u0006H\'\u00a8\u0006\t"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/CharacterDao;", "", "getAll", "", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/model/CharacterModel;", "insert", "", "character", "truncate", "app_debug"})
public abstract interface CharacterDao {
    
    @androidx.room.Insert(onConflict = 5)
    public abstract void insert(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel character);
    
    @org.jetbrains.annotations.NotNull
    @androidx.room.Query(value = "SELECT * FROM characters")
    public abstract java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.model.CharacterModel> getAll();
    
    @androidx.room.Query(value = "DELETE FROM characters")
    public abstract void truncate();
}