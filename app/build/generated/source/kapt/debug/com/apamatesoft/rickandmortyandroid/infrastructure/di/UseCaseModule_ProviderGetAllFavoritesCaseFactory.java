package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.repository.FavoriteRepository;
import com.apamatesoft.usecase.GetAllFavoritesCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class UseCaseModule_ProviderGetAllFavoritesCaseFactory implements Factory<GetAllFavoritesCase> {
  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  public UseCaseModule_ProviderGetAllFavoritesCaseFactory(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public GetAllFavoritesCase get() {
    return providerGetAllFavoritesCase(favoriteRepositoryProvider.get());
  }

  public static UseCaseModule_ProviderGetAllFavoritesCaseFactory create(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new UseCaseModule_ProviderGetAllFavoritesCaseFactory(favoriteRepositoryProvider);
  }

  public static GetAllFavoritesCase providerGetAllFavoritesCase(
      FavoriteRepository favoriteRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.providerGetAllFavoritesCase(favoriteRepository));
  }
}
