package com.example.leboncointest.data

import com.example.leboncointest.domain.SongsData

interface SongsRepository {
    suspend fun getSongsData(): SongsData
}