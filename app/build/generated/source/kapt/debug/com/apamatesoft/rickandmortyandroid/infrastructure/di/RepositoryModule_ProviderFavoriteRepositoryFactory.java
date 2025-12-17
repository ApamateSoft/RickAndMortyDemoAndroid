package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.repository.FavoriteRepository;
import com.apamatesoft.repository.localSource.FavoriteLocalSource;
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
public final class RepositoryModule_ProviderFavoriteRepositoryFactory implements Factory<FavoriteRepository> {
  private final Provider<FavoriteLocalSource> localSourceProvider;

  public RepositoryModule_ProviderFavoriteRepositoryFactory(
      Provider<FavoriteLocalSource> localSourceProvider) {
    this.localSourceProvider = localSourceProvider;
  }

  @Override
  public FavoriteRepository get() {
    return providerFavoriteRepository(localSourceProvider.get());
  }

  public static RepositoryModule_ProviderFavoriteRepositoryFactory create(
      Provider<FavoriteLocalSource> localSourceProvider) {
    return new RepositoryModule_ProviderFavoriteRepositoryFactory(localSourceProvider);
  }

  public static FavoriteRepository providerFavoriteRepository(FavoriteLocalSource localSource) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.providerFavoriteRepository(localSource));
  }
}
