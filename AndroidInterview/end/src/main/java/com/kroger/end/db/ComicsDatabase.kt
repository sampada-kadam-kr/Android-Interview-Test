package com.kroger.end.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Comic::class], version = 1)
abstract class ComicsDatabase : RoomDatabase() {

    abstract fun comicDao(): ComicDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: ComicsDatabase? = null

        fun getDatabase(context: Context): ComicsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ComicsDatabase::class.java,
                    "comic_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}