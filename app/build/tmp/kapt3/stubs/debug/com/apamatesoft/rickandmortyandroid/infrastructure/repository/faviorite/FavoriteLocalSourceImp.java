package com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/repository/faviorite/FavoriteLocalSourceImp;", "Lcom/apamatesoft/repository/localSource/FavoriteLocalSource;", "dao", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/FavoriteDao;", "(Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/FavoriteDao;)V", "addFavorite", "", "favorite", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFavorites", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeFavorite", "app_debug"})
public final class FavoriteLocalSourceImp implements com.apamatesoft.repository.localSource.FavoriteLocalSource {
    private final com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao dao = null;
    
    @javax.inject.Inject
    public FavoriteLocalSourceImp(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object addFavorite(int favorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object removeFavorite(int favorite, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object loadFavorites(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> continuation) {
        return null;
    }
}