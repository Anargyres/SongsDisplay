package com.example.leboncointest.data

import com.example.leboncointest.domain.SongsData

class SongsRepositoryImpl(
    private val remoteSongs: RemoteSongs
) : SongsRepository {
    override suspend fun getSongsData(): SongsData {
        return remoteSongs.getSongsData()
    }
}