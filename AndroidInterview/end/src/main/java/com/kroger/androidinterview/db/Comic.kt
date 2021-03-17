package com.kroger.androidinterview.db

import androidx.room.*

@Entity(tableName = "comic_table")
class Comic(
    val month: String,
    @PrimaryKey val num: Long,
    val link: String = "",
    val year: String,
    val news: String = "",
    val safe_title: String,
    val transcript: String = "",
    val alt: String,
    val img: String,
    val title: String,
    val day: String
)


@Dao
interface ComicDao {

    @Query("SELECT * FROM comic_table ORDER BY num DESC")
    fun getComics(): List<Comic>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(comic: Comic)

    @Query("DELETE FROM comic_table")
    suspend fun deleteAll()
}