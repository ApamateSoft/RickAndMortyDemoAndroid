package com.apamatesoft.rickandmortyandroid.infrastructure.api.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/infrastructure/api/dto/CharacterPageDto;", "", "info", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/api/dto/InfoDto;", "results", "", "Lcom/apamatesoft/rickandmortyandroid/infrastructure/api/dto/CharacterDto;", "(Lcom/apamatesoft/rickandmortyandroid/infrastructure/api/dto/InfoDto;Ljava/util/List;)V", "getInfo", "()Lcom/apamatesoft/rickandmortyandroid/infrastructure/api/dto/InfoDto;", "getResults", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class CharacterPageDto {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "info")
    private final com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto info = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "results")
    private final java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto> results = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterPageDto copy(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto info, @org.jetbrains.annotations.NotNull
    java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto> results) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public CharacterPageDto(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto info, @org.jetbrains.annotations.NotNull
    java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto> results) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.InfoDto getInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.apamatesoft.rickandmortyandroid.infrastructure.api.dto.CharacterDto> getResults() {
        return null;
    }
}