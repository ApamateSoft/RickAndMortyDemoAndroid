package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.repository.FavoriteRepository;
import com.apamatesoft.usecase.AddFavoriteCase;
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
public final class UseCaseModule_ProviderAddFavoriteCaseFactory implements Factory<AddFavoriteCase> {
  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  public UseCaseModule_ProviderAddFavoriteCaseFactory(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public AddFavoriteCase get() {
    return providerAddFavoriteCase(favoriteRepositoryProvider.get());
  }

  public static UseCaseModule_ProviderAddFavoriteCaseFactory create(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new UseCaseModule_ProviderAddFavoriteCaseFactory(favoriteRepositoryProvider);
  }

  public static AddFavoriteCase providerAddFavoriteCase(FavoriteRepository favoriteRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.providerAddFavoriteCase(favoriteRepository));
  }
}
