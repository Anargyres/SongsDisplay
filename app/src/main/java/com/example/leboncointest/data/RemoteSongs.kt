package com.example.leboncointest.data

import com.example.leboncointest.domain.SongsData

class RemoteSongs(private val songsService: SongsService) {
    /**
     * technical-test.json
     */
    suspend fun getSongsData(): SongsData {
        val response = songsService.getSongsData()

        return when {
            response.isSuccessful -> response.body()?.toEntity() ?: SongsData.ERROR
            else -> SongsData.ERROR
        }
    }
}