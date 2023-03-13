package com.dkb.urlshortner.service

import com.dkb.urlshortner.entity.URL
import com.dkb.urlshortner.repository.UrlRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class CommandServiceTest {

    private var repository: UrlRepository = mock(UrlRepository::class.java)
    private lateinit var commandService: CommandService

    @BeforeEach
    fun setup() {
        commandService = CommandService(repository)
    }

    @Test
    fun `shortenUrl should return hash`() {
        `when`(repository.findByLongURL(anyString())).thenReturn(null)

        val shortUrl = commandService.shortenURL(anyString())

        verify(repository, times(1)).save(any())
        assertNotNull(shortUrl)
    }

    @Test
    fun `shortenUrl should return hash from db`() {
        val url = URL("abcd", "https://www.google.com")
        `when`(repository.findByLongURL(anyString())).thenReturn(url)

        val shortUrl = commandService.shortenURL("https://www.google.com")

        verify(repository, times(0)).save(any())
        assertEquals("abcd", shortUrl)
    }
}