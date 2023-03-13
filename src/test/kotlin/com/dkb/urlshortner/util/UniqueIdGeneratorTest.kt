package com.dkb.urlshortner.util

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock

class UniqueIdGeneratorTest {
    private var timeManager = mock(TimeManager::class.java)
    private lateinit var uniqueIdGenerator: UniqueIdGenerator

    @BeforeEach
    fun setUp() {
        uniqueIdGenerator = UniqueIdGenerator.getInstance(timeManager)
    }

    @Test
    fun `nextId should generate unique Ids`() {
        val id1 = uniqueIdGenerator.nextId()
        val id2 = uniqueIdGenerator.nextId()

        assertNotEquals(id1, id2)
    }
}
