package com.example.leboncointest.domain

data class SongsData(
    val elements: List<SongsElements>
) {
    companion object {
        val ERROR =
            SongsData(listOf())
    }
}

data class SongsElements(
    val albumId: String,
    val id: String,
    val titre: String?,
    val url: String?,
    val thumbnailUrl: String?
)