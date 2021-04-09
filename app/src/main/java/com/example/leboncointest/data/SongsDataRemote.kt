package com.example.leboncointest.data

import com.example.leboncointest.domain.SongsData
import com.example.leboncointest.domain.SongsElements

data class SongsDataRemote(
    val elements: List<SongsElements>
) {
    fun toEntity(): SongsData {
        return SongsData(
            elements = elements
        )
    }
}