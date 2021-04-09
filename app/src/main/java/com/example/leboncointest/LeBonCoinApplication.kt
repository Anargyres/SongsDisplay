package com.example.leboncointest

import android.app.Application
import com.example.leboncointest.injection.appModule
import com.example.leboncointest.injection.domainModule
import com.example.leboncointest.injection.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class LeBonCoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@LeBonCoinApplication)
            modules(
                listOf(
                    appModule,
                    presentationModule,
                    domainModule
                )
            )
        }
    }
}