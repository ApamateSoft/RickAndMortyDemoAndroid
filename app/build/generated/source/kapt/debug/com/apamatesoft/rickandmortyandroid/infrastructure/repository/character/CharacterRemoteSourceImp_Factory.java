package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character;

import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi;
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
public final class CharacterRemoteSourceImp_Factory implements Factory<CharacterRemoteSourceImp> {
  private final Provider<CharacterApi> characterApiProvider;

  public CharacterRemoteSourceImp_Factory(Provider<CharacterApi> characterApiProvider) {
    this.characterApiProvider = characterApiProvider;
  }

  @Override
  public CharacterRemoteSourceImp get() {
    return newInstance(characterApiProvider.get());
  }

  public static CharacterRemoteSourceImp_Factory create(
      Provider<CharacterApi> characterApiProvider) {
    return new CharacterRemoteSourceImp_Factory(characterApiProvider);
  }

  public static CharacterRemoteSourceImp newInstance(CharacterApi characterApi) {
    return new CharacterRemoteSourceImp(characterApi);
  }
}
