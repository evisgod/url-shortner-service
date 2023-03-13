package com.dkb.urlshortner.service

interface QueryUseCase {
    fun getLongURL(hash: String): String
}
