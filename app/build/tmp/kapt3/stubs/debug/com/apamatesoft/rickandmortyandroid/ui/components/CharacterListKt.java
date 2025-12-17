package com.apamatesoft.rickandmortyandroid.ui.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a|\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0003\u001a\u001a\u0010\u0010\u001a\u00020\u0001*\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0003\u00a8\u0006\u0013"}, d2 = {"CharacterList", "", "isLoading", "", "characters", "", "Lcom/apamatesoft/domain/entity/Character;", "favoriteList", "", "onItemClick", "Lkotlin/Function1;", "onAddToFavorite", "onRemoveFromFavorite", "onLoadMore", "Lkotlin/Function0;", "PreviewCharacterList", "OnBottomReached", "Landroidx/compose/foundation/lazy/LazyListState;", "loadMore", "app_debug"})
public final class CharacterListKt {
    
    @androidx.compose.runtime.Composable
    public static final void CharacterList(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.util.List<com.apamatesoft.domain.entity.Character> characters, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.Integer> favoriteList, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.apamatesoft.domain.entity.Character, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.apamatesoft.domain.entity.Character, kotlin.Unit> onAddToFavorite, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.apamatesoft.domain.entity.Character, kotlin.Unit> onRemoveFromFavorite, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onLoadMore) {
    }
    
    @androidx.compose.runtime.Composable
    private static final void OnBottomReached(androidx.compose.foundation.lazy.LazyListState $this$OnBottomReached, kotlin.jvm.functions.Function0<kotlin.Unit> loadMore) {
    }
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES)
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    private static final void PreviewCharacterList() {
    }
}