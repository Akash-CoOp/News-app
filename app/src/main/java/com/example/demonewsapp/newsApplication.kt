package com.example.demonewsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class newsApplication : Application(){
    override fun onCreate() {
        super.onCreate()

    }
}