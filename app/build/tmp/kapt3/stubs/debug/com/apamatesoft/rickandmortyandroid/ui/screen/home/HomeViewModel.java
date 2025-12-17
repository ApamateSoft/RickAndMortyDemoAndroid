package com.apamatesoft.rickandmortyandroid.ui.screen.home;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\r\u0010\u001a\u001a\u00020\u0015H\u0001\u00a2\u0006\u0002\b\u001bJ\r\u0010\u001c\u001a\u00020\u0015H\u0001\u00a2\u0006\u0002\b\u001dJ\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@AX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\""}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/ui/screen/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "characterRequestCase", "Lcom/apamatesoft/usecase/CharacterRequestCase;", "addFavoriteCase", "Lcom/apamatesoft/usecase/AddFavoriteCase;", "removeFavoriteCase", "Lcom/apamatesoft/usecase/RemoveFavoriteCase;", "getAllFavoritesCase", "Lcom/apamatesoft/usecase/GetAllFavoritesCase;", "(Lcom/apamatesoft/usecase/CharacterRequestCase;Lcom/apamatesoft/usecase/AddFavoriteCase;Lcom/apamatesoft/usecase/RemoveFavoriteCase;Lcom/apamatesoft/usecase/GetAllFavoritesCase;)V", "<set-?>", "Lcom/apamatesoft/rickandmortyandroid/ui/screen/home/HomeViewModel$State;", "state", "getState", "()Lcom/apamatesoft/rickandmortyandroid/ui/screen/home/HomeViewModel$State;", "setState$app_debug", "(Lcom/apamatesoft/rickandmortyandroid/ui/screen/home/HomeViewModel$State;)V", "state$delegate", "Landroidx/compose/runtime/MutableState;", "addToFavorite", "Lkotlinx/coroutines/Job;", "favorite", "", "characterRequest", "", "loadCharactersFromCache", "loadCharactersFromCache$app_debug", "loadFavoritesFromCache", "loadFavoritesFromCache$app_debug", "loadMoreCharacters", "onCreate", "removeFromFavorite", "State", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    private final com.apamatesoft.usecase.CharacterRequestCase characterRequestCase = null;
    private final com.apamatesoft.usecase.AddFavoriteCase addFavoriteCase = null;
    private final com.apamatesoft.usecase.RemoveFavoriteCase removeFavoriteCase = null;
    private final com.apamatesoft.usecase.GetAllFavoritesCase getAllFavoritesCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState state$delegate = null;
    
    @javax.inject.Inject
    public HomeViewModel(@org.jetbrains.annotations.NotNull
    com.apamatesoft.usecase.CharacterRequestCase characterRequestCase, @org.jetbrains.annotations.NotNull
    com.apamatesoft.usecase.AddFavoriteCase addFavoriteCase, @org.jetbrains.annotations.NotNull
    com.apamatesoft.usecase.RemoveFavoriteCase removeFavoriteCase, @org.jetbrains.annotations.NotNull
    com.apamatesoft.usecase.GetAllFavoritesCase getAllFavoritesCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel.State getState() {
        return null;
    }
    
    @androidx.annotation.VisibleForTesting
    public final void setState$app_debug(@org.jetbrains.annotations.NotNull
    com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel.State p0) {
    }
    
    public final void onCreate() {
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.VisibleForTesting
    public final kotlinx.coroutines.Job loadCharactersFromCache$app_debug() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @androidx.annotation.VisibleForTesting
    public final kotlinx.coroutines.Job loadFavoritesFromCache$app_debug() {
        return null;
    }
    
    public final void characterRequest() {
    }
    
    public final void loadMoreCharacters() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job addToFavorite(int favorite) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.Job removeFromFavorite(int favorite) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00c6\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u00c6\u0003J=\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/apamatesoft/rickandmortyandroid/ui/screen/home/HomeViewModel$State;", "", "loading", "", "hasNetworkError", "characters", "", "Lcom/apamatesoft/domain/entity/Character;", "favorites", "", "(ZZLjava/util/List;Ljava/util/List;)V", "getCharacters", "()Ljava/util/List;", "getFavorites", "getHasNetworkError", "()Z", "getLoading", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
    public static final class State {
        private final boolean loading = false;
        private final boolean hasNetworkError = false;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.apamatesoft.domain.entity.Character> characters = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<java.lang.Integer> favorites = null;
        
        @org.jetbrains.annotations.NotNull
        public final com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel.State copy(boolean loading, boolean hasNetworkError, @org.jetbrains.annotations.NotNull
        java.util.List<com.apamatesoft.domain.entity.Character> characters, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.Integer> favorites) {
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
        
        public State() {
            super();
        }
        
        public State(boolean loading, boolean hasNetworkError, @org.jetbrains.annotations.NotNull
        java.util.List<com.apamatesoft.domain.entity.Character> characters, @org.jetbrains.annotations.NotNull
        java.util.List<java.lang.Integer> favorites) {
            super();
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean getLoading() {
            return false;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean getHasNetworkError() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.apamatesoft.domain.entity.Character> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.apamatesoft.domain.entity.Character> getCharacters() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Integer> component4() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<java.lang.Integer> getFavorites() {
            return null;
        }
    }
}