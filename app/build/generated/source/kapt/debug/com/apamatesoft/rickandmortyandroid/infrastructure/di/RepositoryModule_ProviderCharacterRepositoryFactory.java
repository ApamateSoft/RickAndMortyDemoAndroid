package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.repository.CharacterRepository;
import com.apamatesoft.repository.localSource.CharacterLocalSource;
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource;
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
public final class RepositoryModule_ProviderCharacterRepositoryFactory implements Factory<CharacterRepository> {
  private final Provider<CharacterLocalSource> localProvider;

  private final Provider<CharacterRemoteSource> remoteProvider;

  public RepositoryModule_ProviderCharacterRepositoryFactory(
      Provider<CharacterLocalSource> localProvider,
      Provider<CharacterRemoteSource> remoteProvider) {
    this.localProvider = localProvider;
    this.remoteProvider = remoteProvider;
  }

  @Override
  public CharacterRepository get() {
    return providerCharacterRepository(localProvider.get(), remoteProvider.get());
  }

  public static RepositoryModule_ProviderCharacterRepositoryFactory create(
      Provider<CharacterLocalSource> localProvider,
      Provider<CharacterRemoteSource> remoteProvider) {
    return new RepositoryModule_ProviderCharacterRepositoryFactory(localProvider, remoteProvider);
  }

  public static CharacterRepository providerCharacterRepository(CharacterLocalSource local,
      CharacterRemoteSource remote) {
    return Preconditions.checkNotNullFromProvides(RepositoryModule.INSTANCE.providerCharacterRepository(local, remote));
  }
}
