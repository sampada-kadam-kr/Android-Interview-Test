package com.kroger.end

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ComicApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}