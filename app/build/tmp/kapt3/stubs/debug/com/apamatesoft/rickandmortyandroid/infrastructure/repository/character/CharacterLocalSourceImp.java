package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u001f\u0010\u000b\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000e"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/repository/character/CharacterLocalSourceImp;", "Lcom/apamatesoft/repository/localSource/CharacterLocalSource;", "dao", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/CharacterDao;", "(Lcom/apamatesoft/rickandmortyandroid/infrastructure/localStorage/dao/CharacterDao;)V", "clear", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadCharacters", "", "Lcom/apamatesoft/domain/entity/Character;", "saveCharacters", "characters", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CharacterLocalSourceImp implements com.apamatesoft.repository.localSource.CharacterLocalSource {
    private final com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao dao = null;
    
    @javax.inject.Inject
    public CharacterLocalSourceImp(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object saveCharacters(@org.jetbrains.annotations.NotNull
    java.util.List<com.apamatesoft.domain.entity.Character> characters, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object loadCharacters(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.apamatesoft.domain.entity.Character>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object clear(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}