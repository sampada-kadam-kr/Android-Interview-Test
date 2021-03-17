package com.kroger.start.di

import com.kroger.start.ComicRepository
import com.kroger.start.LocalRepository
import com.kroger.start.RemoteRepository

import com.kroger.start.db.ComicDao
import com.kroger.start.network.ComicService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@InstallIn(ViewModelComponent::class)
@Module
class ComicViewModelModule {

    @Local
    @Provides
    fun provideLocalRepository(
        dao: ComicDao
    ): ComicRepository {
        return LocalRepository(dao)
    }

    @Remote
    @Provides
    fun provideRemoteRepository(
        comicService: ComicService
    ): ComicRepository {
        return RemoteRepository(comicService)
    }
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Local

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Remote