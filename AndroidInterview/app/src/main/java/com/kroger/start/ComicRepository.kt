package com.kroger.start


interface ComicRepository {
    suspend fun getCurrentComic()
}

abstract class RemoteRepository constructor() :
    ComicRepository {


}


abstract class LocalRepository constructor() :
    ComicRepository {

}