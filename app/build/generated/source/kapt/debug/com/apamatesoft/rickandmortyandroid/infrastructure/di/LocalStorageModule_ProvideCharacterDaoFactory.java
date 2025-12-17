package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao;
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
public final class LocalStorageModule_ProvideCharacterDaoFactory implements Factory<CharacterDao> {
  private final Provider<AppDatabase> dbProvider;

  public LocalStorageModule_ProvideCharacterDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public CharacterDao get() {
    return provideCharacterDao(dbProvider.get());
  }

  public static LocalStorageModule_ProvideCharacterDaoFactory create(
      Provider<AppDatabase> dbProvider) {
    return new LocalStorageModule_ProvideCharacterDaoFactory(dbProvider);
  }

  public static CharacterDao provideCharacterDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(LocalStorageModule.INSTANCE.provideCharacterDao(db));
  }
}
