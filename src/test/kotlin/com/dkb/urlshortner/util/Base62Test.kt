package com.dkb.urlshortner.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Base62Test {
    @Test
    fun `test encoding Zero`() {
        val num = 0L
        val encoded = num.encode()
        assertEquals("0", encoded)
    }

    @Test
    fun `test encoding small numbers`() {
        val num = 1234L
        val encoded = num.encode()
        assertEquals("Ju", encoded)
    }

    @Test
    fun `test encoding large numbers`() {
        val num = 9876543210L
        val encoded = num.encode()
        assertEquals("AmOy42", encoded)
    }

    @Test
    fun `test encoding of a number that is exactly a power of 62`() {
        val num = 62L
        val encoded = num.encode()
        assertEquals("10", encoded)
    }
}