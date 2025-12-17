package com.apamatesoft.rickandmortyandroid.infrastructure.repository.character;

import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao;
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
public final class CharacterLocalSourceImp_Factory implements Factory<CharacterLocalSourceImp> {
  private final Provider<CharacterDao> daoProvider;

  public CharacterLocalSourceImp_Factory(Provider<CharacterDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public CharacterLocalSourceImp get() {
    return newInstance(daoProvider.get());
  }

  public static CharacterLocalSourceImp_Factory create(Provider<CharacterDao> daoProvider) {
    return new CharacterLocalSourceImp_Factory(daoProvider);
  }

  public static CharacterLocalSourceImp newInstance(CharacterDao dao) {
    return new CharacterLocalSourceImp(dao);
  }
}
