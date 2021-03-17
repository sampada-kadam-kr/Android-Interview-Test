package com.kroger.androidinterview

import com.kroger.androidinterview.db.ComicDao
import com.kroger.androidinterview.network.ComicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ComicRepository {
    suspend fun getCurrentComic()
}

class RemoteRepository @Inject constructor(private val comicService: ComicService) : ComicRepository {

    override suspend fun getCurrentComic() {
        withContext(Dispatchers.IO) {
            comicService.getCurrentComic()
        }
    }
}

class LocalRepository @Inject constructor(comicDao: ComicDao) : ComicRepository {
    override suspend fun getCurrentComic() {


    }

}