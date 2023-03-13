package com.dkb.urlshortner.service

import com.dkb.urlshortner.entity.URL
import com.dkb.urlshortner.exception.HashNotFoundException
import com.dkb.urlshortner.repository.UrlRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertThrows
import org.mockito.Mockito

class QueryServiceTest {

    private var repository: UrlRepository = Mockito.mock(UrlRepository::class.java)
    private lateinit var queryService: QueryService

    @BeforeEach
    fun setup() {
        queryService = QueryService(repository)
    }

    @Test
    fun `getLongURL should return long URL for a hash`() {
        val url = URL("abcd", "https://www.google.com")
        Mockito.`when`(repository.findByHash(Mockito.anyString())).thenReturn(url)

        val longURL = queryService.getLongURL("abcd")

        assertEquals("https://www.google.com", longURL)
    }

    @Test
    fun `getLongURL should throw exception for hash not found`() {
        Mockito.`when`(repository.findByHash(Mockito.anyString())).thenReturn(null)

        assertThrows(HashNotFoundException::class.java) {
            queryService.getLongURL(Mockito.anyString())
        }
    }
}