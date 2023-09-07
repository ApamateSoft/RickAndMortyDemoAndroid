package com.apamatesoft.rickandmortyandroid.infrastructure.di

import com.apamatesoft.rickandmortyandroid.infrastructure.api.CharacterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun providerRetrofit(): Retrofit {

        // TODO: add url to environment
        val BASE_URL = "https://rickandmortyapi.com"

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    @Singleton
    @Provides
    fun providerCharacterApi(retrofit: Retrofit): CharacterApi {
        return retrofit.create(CharacterApi::class.java)
    }

}