package com.kroger.end.network

import com.kroger.end.db.Comic
import retrofit2.http.GET

interface ComicService {

    @GET("/info.0.json")
    suspend fun getCurrentComic(): Comic

}