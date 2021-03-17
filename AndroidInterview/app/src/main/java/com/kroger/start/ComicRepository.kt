package com.kroger.start

import com.kroger.start.db.Comic

interface ComicRepository {
    suspend fun getCurrentComic(): Comic
}

abstract class RemoteRepository constructor() :
    ComicRepository {


}


abstract class LocalRepository constructor() :
    ComicRepository {

}