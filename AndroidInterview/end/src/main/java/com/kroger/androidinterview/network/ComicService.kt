package com.kroger.androidinterview.network

import com.kroger.androidinterview.db.Comic
import retrofit2.http.GET

interface ComicService {

    @GET("/info.0.json")
    suspend fun getCurrentComic(): Comic

}