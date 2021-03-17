package com.kroger.androidinterview.di

import com.kroger.androidinterview.db.ComicDao
import com.kroger.androidinterview.db.ComicsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideComicDao(appDatabase: ComicsDatabase): ComicDao {
        return appDatabase.comicDao()
    }


}