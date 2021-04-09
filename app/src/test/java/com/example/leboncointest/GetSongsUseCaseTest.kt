package com.example.leboncointest

import com.example.leboncointest.data.SongsRepository
import com.example.leboncointest.domain.GetSongsUseCase
import com.example.leboncointest.domain.SongsData
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class GetSongsUseCaseTest {

    private val songsRepository: SongsRepository = mockk()

    private val classUnderTest = GetSongsUseCase(songsRepository)

    @Test
    fun `Get Songs Data`() {
        runBlocking {
            //GIVEN
            val expectedResult = SongsData(
                elements = listOf()
            )

            coEvery { songsRepository.getSongsData() } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke()

            //THEN
            assertEquals(expectedResult, result)

        }
    }
}