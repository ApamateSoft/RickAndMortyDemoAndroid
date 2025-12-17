package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.repository.FavoriteRepository;
import com.apamatesoft.usecase.RemoveFavoriteCase;
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
public final class UseCaseModule_ProviderRemoveFavoriteCaseFactory implements Factory<RemoveFavoriteCase> {
  private final Provider<FavoriteRepository> favoriteRepositoryProvider;

  public UseCaseModule_ProviderRemoveFavoriteCaseFactory(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    this.favoriteRepositoryProvider = favoriteRepositoryProvider;
  }

  @Override
  public RemoveFavoriteCase get() {
    return providerRemoveFavoriteCase(favoriteRepositoryProvider.get());
  }

  public static UseCaseModule_ProviderRemoveFavoriteCaseFactory create(
      Provider<FavoriteRepository> favoriteRepositoryProvider) {
    return new UseCaseModule_ProviderRemoveFavoriteCaseFactory(favoriteRepositoryProvider);
  }

  public static RemoveFavoriteCase providerRemoveFavoriteCase(
      FavoriteRepository favoriteRepository) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.providerRemoveFavoriteCase(favoriteRepository));
  }
}
