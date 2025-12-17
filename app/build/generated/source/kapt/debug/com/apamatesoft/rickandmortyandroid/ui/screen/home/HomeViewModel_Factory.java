package com.apamatesoft.rickandmortyandroid.ui.screen.home;

import com.apamatesoft.usecase.AddFavoriteCase;
import com.apamatesoft.usecase.CharacterRequestCase;
import com.apamatesoft.usecase.GetAllFavoritesCase;
import com.apamatesoft.usecase.RemoveFavoriteCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<CharacterRequestCase> characterRequestCaseProvider;

  private final Provider<AddFavoriteCase> addFavoriteCaseProvider;

  private final Provider<RemoveFavoriteCase> removeFavoriteCaseProvider;

  private final Provider<GetAllFavoritesCase> getAllFavoritesCaseProvider;

  public HomeViewModel_Factory(Provider<CharacterRequestCase> characterRequestCaseProvider,
      Provider<AddFavoriteCase> addFavoriteCaseProvider,
      Provider<RemoveFavoriteCase> removeFavoriteCaseProvider,
      Provider<GetAllFavoritesCase> getAllFavoritesCaseProvider) {
    this.characterRequestCaseProvider = characterRequestCaseProvider;
    this.addFavoriteCaseProvider = addFavoriteCaseProvider;
    this.removeFavoriteCaseProvider = removeFavoriteCaseProvider;
    this.getAllFavoritesCaseProvider = getAllFavoritesCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(characterRequestCaseProvider.get(), addFavoriteCaseProvider.get(), removeFavoriteCaseProvider.get(), getAllFavoritesCaseProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<CharacterRequestCase> characterRequestCaseProvider,
      Provider<AddFavoriteCase> addFavoriteCaseProvider,
      Provider<RemoveFavoriteCase> removeFavoriteCaseProvider,
      Provider<GetAllFavoritesCase> getAllFavoritesCaseProvider) {
    return new HomeViewModel_Factory(characterRequestCaseProvider, addFavoriteCaseProvider, removeFavoriteCaseProvider, getAllFavoritesCaseProvider);
  }

  public static HomeViewModel newInstance(CharacterRequestCase characterRequestCase,
      AddFavoriteCase addFavoriteCase, RemoveFavoriteCase removeFavoriteCase,
      GetAllFavoritesCase getAllFavoritesCase) {
    return new HomeViewModel(characterRequestCase, addFavoriteCase, removeFavoriteCase, getAllFavoritesCase);
  }
}
