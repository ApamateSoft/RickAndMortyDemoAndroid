package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao;
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
public final class LocalStorageModule_ProvideFavoriteDaoFactory implements Factory<FavoriteDao> {
  private final Provider<AppDatabase> dbProvider;

  public LocalStorageModule_ProvideFavoriteDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FavoriteDao get() {
    return provideFavoriteDao(dbProvider.get());
  }

  public static LocalStorageModule_ProvideFavoriteDaoFactory create(
      Provider<AppDatabase> dbProvider) {
    return new LocalStorageModule_ProvideFavoriteDaoFactory(dbProvider);
  }

  public static FavoriteDao provideFavoriteDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(LocalStorageModule.INSTANCE.provideFavoriteDao(db));
  }
}
