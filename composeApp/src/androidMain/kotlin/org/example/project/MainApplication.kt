package org.example.project

import android.app.Application
import data.DataBaseDriverFactoy
import di.appModule
import org.expenseApp.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            modules(appModule(AppDatabase.invoke(DataBaseDriverFactoy(this@MainApplication).createDriver())))
        }
    }
}