package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class ApiModule_ProviderCharacterApiFactory implements Factory<CharacterApi> {
  private final Provider<Retrofit> retrofitProvider;

  public ApiModule_ProviderCharacterApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public CharacterApi get() {
    return providerCharacterApi(retrofitProvider.get());
  }

  public static ApiModule_ProviderCharacterApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new ApiModule_ProviderCharacterApiFactory(retrofitProvider);
  }

  public static CharacterApi providerCharacterApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.providerCharacterApi(retrofit));
  }
}
