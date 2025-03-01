package com.cristiancizmar.rickandmorty.di

import com.cristiancizmar.rickandmorty.data.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCharactersRepository() = CharactersRepository()

    @Provides
    @Singleton
    fun provideCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

}