package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.repository.CharacterRepository;
import com.apamatesoft.usecase.CharacterRequestCase;
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
public final class UseCaseModule_ProviderCharacterRequestCaseFactory implements Factory<CharacterRequestCase> {
  private final Provider<CharacterRepository> characterRepoProvider;

  public UseCaseModule_ProviderCharacterRequestCaseFactory(
      Provider<CharacterRepository> characterRepoProvider) {
    this.characterRepoProvider = characterRepoProvider;
  }

  @Override
  public CharacterRequestCase get() {
    return providerCharacterRequestCase(characterRepoProvider.get());
  }

  public static UseCaseModule_ProviderCharacterRequestCaseFactory create(
      Provider<CharacterRepository> characterRepoProvider) {
    return new UseCaseModule_ProviderCharacterRequestCaseFactory(characterRepoProvider);
  }

  public static CharacterRequestCase providerCharacterRequestCase(
      CharacterRepository characterRepo) {
    return Preconditions.checkNotNullFromProvides(UseCaseModule.INSTANCE.providerCharacterRequestCase(characterRepo));
  }
}
