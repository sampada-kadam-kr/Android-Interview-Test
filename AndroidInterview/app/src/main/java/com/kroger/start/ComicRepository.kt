package com.kroger.start

import com.kroger.start.db.Comic
import com.kroger.start.db.ComicDao
import com.kroger.start.network.ComicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ComicRepository {
    suspend fun getCurrentComic(): Comic
}

class RemoteRepository @Inject constructor(private val comicService: ComicService) :
    ComicRepository {

    override suspend fun getCurrentComic() =
        withContext(Dispatchers.IO) {
            comicService.getCurrentComic()
        }
}


class LocalRepository @Inject constructor(private val comicDao: ComicDao) : ComicRepository {
    override suspend fun getCurrentComic() = comicDao.getComics()[0]
}