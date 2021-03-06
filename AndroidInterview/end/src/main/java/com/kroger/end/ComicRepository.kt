package com.kroger.end

import com.kroger.end.db.Comic
import com.kroger.end.db.ComicDao
import com.kroger.end.network.ComicService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface ComicRepository {
    suspend fun getCurrentComic(): Comic
    suspend fun insertComic(comic: Comic)
}

class RemoteRepository @Inject constructor(private val comicService: ComicService) :
    ComicRepository {

    override suspend fun insertComic(comic: Comic) {
        TODO("Not  applicable")
    }

    override suspend fun getCurrentComic() =
        withContext(Dispatchers.IO) {
            comicService.getCurrentComic()
        }
}


class LocalRepository @Inject constructor(private val comicDao: ComicDao) : ComicRepository {

    override suspend fun insertComic(comic: Comic) = comicDao.insert(comic)
    override suspend fun getCurrentComic() = comicDao.getComics()[0]
}