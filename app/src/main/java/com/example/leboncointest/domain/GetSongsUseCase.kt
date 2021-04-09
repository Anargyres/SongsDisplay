package com.example.leboncointest.domain

import com.example.leboncointest.data.SongsRepository

class GetSongsUseCase(
    private val songsRepository: SongsRepository
) {
    suspend fun invoke(): SongsData {
        return songsRepository.getSongsData()
    }
}