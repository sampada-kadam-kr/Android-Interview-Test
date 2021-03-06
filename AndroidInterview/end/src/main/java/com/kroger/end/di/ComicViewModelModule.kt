package com.kroger.end.di

import com.kroger.end.ComicRepository
import com.kroger.end.LocalRepository
import com.kroger.end.RemoteRepository

import com.kroger.end.db.ComicDao
import com.kroger.end.network.ComicService
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