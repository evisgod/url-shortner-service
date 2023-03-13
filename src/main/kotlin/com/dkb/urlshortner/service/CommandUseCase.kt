package com.dkb.urlshortner.service

interface CommandUseCase {
    fun shortenURL(longURL: String): String
}
