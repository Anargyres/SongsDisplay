package com.example.leboncointest.data

import retrofit2.Response
import retrofit2.http.GET

interface SongsService {

    @GET("technical-test.json")
    suspend fun getSongsData(): Response<SongsDataRemote>

}