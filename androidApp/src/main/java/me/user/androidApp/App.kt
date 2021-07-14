package me.user.androidApp

import android.app.Application
import me.user.shared.di.initKoin

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}