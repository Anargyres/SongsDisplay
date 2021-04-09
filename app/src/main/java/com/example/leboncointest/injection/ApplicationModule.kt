package com.example.leboncointest.injection

import com.example.leboncointest.data.RemoteSongs
import com.example.leboncointest.data.SongsRepository
import com.example.leboncointest.data.SongsRepositoryImpl
import com.example.leboncointest.data.SongsService
import com.example.leboncointest.domain.GetSongsUseCase
import com.example.leboncointest.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val appModule = module {

    single<SongsRepository> { SongsRepositoryImpl(get()) }

    single { RemoteSongs(get()) }

    single<SongsService> { createWebService("https://static.leboncoin.fr/img/shared/") }
}

val presentationModule = module {

    viewModel { MainViewModel(get()) }
}

val domainModule = module {

    single { GetSongsUseCase(get()) }
}

inline fun <reified T> createWebService(url: String): T {
    return Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create()
}