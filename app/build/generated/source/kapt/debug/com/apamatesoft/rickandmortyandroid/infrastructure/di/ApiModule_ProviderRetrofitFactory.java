package com.apamatesoft.rickandmortyandroid.infrastructure.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
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
public final class ApiModule_ProviderRetrofitFactory implements Factory<Retrofit> {
  @Override
  public Retrofit get() {
    return providerRetrofit();
  }

  public static ApiModule_ProviderRetrofitFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static Retrofit providerRetrofit() {
    return Preconditions.checkNotNullFromProvides(ApiModule.INSTANCE.providerRetrofit());
  }

  private static final class InstanceHolder {
    private static final ApiModule_ProviderRetrofitFactory INSTANCE = new ApiModule_ProviderRetrofitFactory();
  }
}
