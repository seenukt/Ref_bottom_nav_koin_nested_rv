package com.example.recyclerview

import android.app.Application
import di.repoModule
import di.retrofitModule
import di.videModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import prefs.PrefsDeligate


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        PrefsDeligate.initPreference(this)
        startKoin {
            androidContext(applicationContext)
            modules(listOf(retrofitModule, repoModule,videModelModule))
        }
    }
}