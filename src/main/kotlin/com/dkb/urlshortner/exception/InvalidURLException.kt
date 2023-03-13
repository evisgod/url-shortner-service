package com.dkb.urlshortner.exception

class InvalidURLException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception(message, cause)

class HashNotFoundException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Exception(message, cause)
