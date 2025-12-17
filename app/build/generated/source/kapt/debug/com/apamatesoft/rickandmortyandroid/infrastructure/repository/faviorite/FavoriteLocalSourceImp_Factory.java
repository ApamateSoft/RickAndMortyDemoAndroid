package com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite;

import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao;
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
public final class FavoriteLocalSourceImp_Factory implements Factory<FavoriteLocalSourceImp> {
  private final Provider<FavoriteDao> daoProvider;

  public FavoriteLocalSourceImp_Factory(Provider<FavoriteDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public FavoriteLocalSourceImp get() {
    return newInstance(daoProvider.get());
  }

  public static FavoriteLocalSourceImp_Factory create(Provider<FavoriteDao> daoProvider) {
    return new FavoriteLocalSourceImp_Factory(daoProvider);
  }

  public static FavoriteLocalSourceImp newInstance(FavoriteDao dao) {
    return new FavoriteLocalSourceImp(dao);
  }
}
