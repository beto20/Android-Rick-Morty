package com.alberto.android_rick_morty.di

import android.content.Context
import com.alberto.android_rick_morty.application.App
import com.alberto.android_rick_morty.dataexternal.graphql.ApolloClientImpl
import com.alberto.android_rick_morty.dataexternal.graphql.GraphqlService
import com.alberto.android_rick_morty.dataexternal.service.CharacterService
import com.alberto.android_rick_morty.dataexternal.service.EpisodeService
import com.alberto.android_rick_morty.dataexternal.service.LocationService
import com.alberto.android_rick_morty.dataexternal.service.impl.CharacterServiceImpl
import com.alberto.android_rick_morty.dataexternal.service.impl.EpisodeServiceImpl
import com.alberto.android_rick_morty.dataexternal.service.impl.LocationServiceImpl
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.okHttpClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        val okHttpClient = OkHttpClient.Builder().build()
        return ApolloClient.Builder()
            .serverUrl("https://rickandmortyapi.com/graphql")
            .okHttpClient(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideGraphqlService(apolloClient: ApolloClient): GraphqlService {
        return ApolloClientImpl(apolloClient)
    }

    @Provides
    @Singleton
    fun provideApplication(@ApplicationContext app: Context): App {
        return app as App
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class AppDataModule {
    @Binds
    abstract fun bindEpisodeService(episodeServiceImpl: EpisodeServiceImpl): EpisodeService

    @Binds
    abstract fun bindLocationService(locationServiceImpl: LocationServiceImpl): LocationService

    @Binds
    abstract fun bindCharacterService(characterServiceImpl: CharacterServiceImpl): CharacterService
}