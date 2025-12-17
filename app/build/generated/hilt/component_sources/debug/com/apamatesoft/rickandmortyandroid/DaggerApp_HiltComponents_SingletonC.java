package com.apamatesoft.rickandmortyandroid;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.apamatesoft.repository.CharacterRepository;
import com.apamatesoft.repository.FavoriteRepository;
import com.apamatesoft.repository.localSource.CharacterLocalSource;
import com.apamatesoft.repository.localSource.FavoriteLocalSource;
import com.apamatesoft.repository.remoteSource.CharacterRemoteSource;
import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.ApiModule;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.ApiModule_ProviderCharacterApiFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.ApiModule_ProviderRetrofitFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.LocalStorageModule;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.LocalStorageModule_ProvideCharacterDaoFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.LocalStorageModule_ProvideFavoriteDaoFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.LocalStorageModule_ProviderDatabaseFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.RepositoryModule;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.RepositoryModule_ProviderCharacterRepositoryFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.RepositoryModule_ProviderFavoriteRepositoryFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.UseCaseModule;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.UseCaseModule_ProviderAddFavoriteCaseFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.UseCaseModule_ProviderCharacterRequestCaseFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.UseCaseModule_ProviderGetAllFavoritesCaseFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.di.UseCaseModule_ProviderRemoveFavoriteCaseFactory;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao;
import com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao;
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterLocalSourceImp;
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterRemoteSourceImp;
import com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite.FavoriteLocalSourceImp;
import com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel;
import com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.apamatesoft.usecase.AddFavoriteCase;
import com.apamatesoft.usecase.CharacterRequestCase;
import com.apamatesoft.usecase.GetAllFavoritesCase;
import com.apamatesoft.usecase.RemoveFavoriteCase;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerApp_HiltComponents_SingletonC {
  private DaggerApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder apiModule(ApiModule apiModule) {
      Preconditions.checkNotNull(apiModule);
      return this;
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder localStorageModule(LocalStorageModule localStorageModule) {
      Preconditions.checkNotNull(localStorageModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder repositoryModule(RepositoryModule repositoryModule) {
      Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder useCaseModule(UseCaseModule useCaseModule) {
      Preconditions.checkNotNull(useCaseModule);
      return this;
    }

    public App_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements App_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public App_HiltComponents.ActivityRetainedC build() {
      return new ActivityRetainedCImpl(singletonCImpl);
    }
  }

  private static final class ActivityCBuilder implements App_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements App_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public App_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements App_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements App_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements App_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public App_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements App_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public App_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends App_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends App_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends App_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends App_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return Collections.<String>singleton(HomeViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends App_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<HomeViewModel> homeViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return Collections.<String, Provider<ViewModel>>singletonMap("com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel", ((Provider) homeViewModelProvider));
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.apamatesoft.rickandmortyandroid.ui.screen.home.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.providerCharacterRequestCaseProvider.get(), singletonCImpl.providerAddFavoriteCaseProvider.get(), singletonCImpl.providerRemoveFavoriteCaseProvider.get(), singletonCImpl.providerGetAllFavoritesCaseProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends App_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends App_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends App_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppDatabase> providerDatabaseProvider;

    private Provider<CharacterDao> provideCharacterDaoProvider;

    private Provider<CharacterLocalSourceImp> characterLocalSourceImpProvider;

    private Provider<CharacterLocalSource> bindCharacterLocalSourceProvider;

    private Provider<Retrofit> providerRetrofitProvider;

    private Provider<CharacterApi> providerCharacterApiProvider;

    private Provider<CharacterRemoteSourceImp> characterRemoteSourceImpProvider;

    private Provider<CharacterRemoteSource> bindCharacterRemoteSourceProvider;

    private Provider<CharacterRepository> providerCharacterRepositoryProvider;

    private Provider<CharacterRequestCase> providerCharacterRequestCaseProvider;

    private Provider<FavoriteDao> provideFavoriteDaoProvider;

    private Provider<FavoriteLocalSourceImp> favoriteLocalSourceImpProvider;

    private Provider<FavoriteLocalSource> bindFavoriteLocalSourceProvider;

    private Provider<FavoriteRepository> providerFavoriteRepositoryProvider;

    private Provider<AddFavoriteCase> providerAddFavoriteCaseProvider;

    private Provider<RemoveFavoriteCase> providerRemoveFavoriteCaseProvider;

    private Provider<GetAllFavoritesCase> providerGetAllFavoritesCaseProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.providerDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 4));
      this.provideCharacterDaoProvider = DoubleCheck.provider(new SwitchingProvider<CharacterDao>(singletonCImpl, 3));
      this.characterLocalSourceImpProvider = new SwitchingProvider<>(singletonCImpl, 2);
      this.bindCharacterLocalSourceProvider = DoubleCheck.provider((Provider) characterLocalSourceImpProvider);
      this.providerRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 7));
      this.providerCharacterApiProvider = DoubleCheck.provider(new SwitchingProvider<CharacterApi>(singletonCImpl, 6));
      this.characterRemoteSourceImpProvider = new SwitchingProvider<>(singletonCImpl, 5);
      this.bindCharacterRemoteSourceProvider = DoubleCheck.provider((Provider) characterRemoteSourceImpProvider);
      this.providerCharacterRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<CharacterRepository>(singletonCImpl, 1));
      this.providerCharacterRequestCaseProvider = DoubleCheck.provider(new SwitchingProvider<CharacterRequestCase>(singletonCImpl, 0));
      this.provideFavoriteDaoProvider = DoubleCheck.provider(new SwitchingProvider<FavoriteDao>(singletonCImpl, 11));
      this.favoriteLocalSourceImpProvider = new SwitchingProvider<>(singletonCImpl, 10);
      this.bindFavoriteLocalSourceProvider = DoubleCheck.provider((Provider) favoriteLocalSourceImpProvider);
      this.providerFavoriteRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<FavoriteRepository>(singletonCImpl, 9));
      this.providerAddFavoriteCaseProvider = DoubleCheck.provider(new SwitchingProvider<AddFavoriteCase>(singletonCImpl, 8));
      this.providerRemoveFavoriteCaseProvider = DoubleCheck.provider(new SwitchingProvider<RemoveFavoriteCase>(singletonCImpl, 12));
      this.providerGetAllFavoritesCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetAllFavoritesCase>(singletonCImpl, 13));
    }

    @Override
    public void injectApp(App app) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.apamatesoft.usecase.CharacterRequestCase 
          return (T) UseCaseModule_ProviderCharacterRequestCaseFactory.providerCharacterRequestCase(singletonCImpl.providerCharacterRepositoryProvider.get());

          case 1: // com.apamatesoft.repository.CharacterRepository 
          return (T) RepositoryModule_ProviderCharacterRepositoryFactory.providerCharacterRepository(singletonCImpl.bindCharacterLocalSourceProvider.get(), singletonCImpl.bindCharacterRemoteSourceProvider.get());

          case 2: // com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterLocalSourceImp 
          return (T) new CharacterLocalSourceImp(singletonCImpl.provideCharacterDaoProvider.get());

          case 3: // com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.CharacterDao 
          return (T) LocalStorageModule_ProvideCharacterDaoFactory.provideCharacterDao(singletonCImpl.providerDatabaseProvider.get());

          case 4: // com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.AppDatabase 
          return (T) LocalStorageModule_ProviderDatabaseFactory.providerDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 5: // com.apamatesoft.rickandmortyandroid.infrastructure.repository.character.CharacterRemoteSourceImp 
          return (T) new CharacterRemoteSourceImp(singletonCImpl.providerCharacterApiProvider.get());

          case 6: // com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi 
          return (T) ApiModule_ProviderCharacterApiFactory.providerCharacterApi(singletonCImpl.providerRetrofitProvider.get());

          case 7: // retrofit2.Retrofit 
          return (T) ApiModule_ProviderRetrofitFactory.providerRetrofit();

          case 8: // com.apamatesoft.usecase.AddFavoriteCase 
          return (T) UseCaseModule_ProviderAddFavoriteCaseFactory.providerAddFavoriteCase(singletonCImpl.providerFavoriteRepositoryProvider.get());

          case 9: // com.apamatesoft.repository.FavoriteRepository 
          return (T) RepositoryModule_ProviderFavoriteRepositoryFactory.providerFavoriteRepository(singletonCImpl.bindFavoriteLocalSourceProvider.get());

          case 10: // com.apamatesoft.rickandmortyandroid.infrastructure.repository.faviorite.FavoriteLocalSourceImp 
          return (T) new FavoriteLocalSourceImp(singletonCImpl.provideFavoriteDaoProvider.get());

          case 11: // com.apamatesoft.rickandmortyandroid.infrastructure.localStorage.dao.FavoriteDao 
          return (T) LocalStorageModule_ProvideFavoriteDaoFactory.provideFavoriteDao(singletonCImpl.providerDatabaseProvider.get());

          case 12: // com.apamatesoft.usecase.RemoveFavoriteCase 
          return (T) UseCaseModule_ProviderRemoveFavoriteCaseFactory.providerRemoveFavoriteCase(singletonCImpl.providerFavoriteRepositoryProvider.get());

          case 13: // com.apamatesoft.usecase.GetAllFavoritesCase 
          return (T) UseCaseModule_ProviderGetAllFavoritesCaseFactory.providerGetAllFavoritesCase(singletonCImpl.providerFavoriteRepositoryProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
