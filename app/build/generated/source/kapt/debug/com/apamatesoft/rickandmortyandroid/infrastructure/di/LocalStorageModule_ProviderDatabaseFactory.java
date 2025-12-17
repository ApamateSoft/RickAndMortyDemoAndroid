package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import android.content.Context;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LocalStorageModule_ProviderDatabaseFactory implements Factory<AppDatabase> {
  private final Provider<Context> contextProvider;

  public LocalStorageModule_ProviderDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public AppDatabase get() {
    return providerDatabase(contextProvider.get());
  }

  public static LocalStorageModule_ProviderDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new LocalStorageModule_ProviderDatabaseFactory(contextProvider);
  }

  public static AppDatabase providerDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(LocalStorageModule.INSTANCE.providerDatabase(context));
  }
}
