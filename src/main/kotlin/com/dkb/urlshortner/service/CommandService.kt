package com.dkb.urlshortner.service

import com.dkb.urlshortner.entity.URL
import com.dkb.urlshortner.repository.UrlRepository
import com.dkb.urlshortner.util.TimeManagerUtil
import com.dkb.urlshortner.util.UniqueIdGenerator
import com.dkb.urlshortner.util.encode
import org.springframework.stereotype.Service

@Service
class CommandService(
    private val repository: UrlRepository
) : CommandUseCase {

    override fun shortenURL(longURL: String): String {
        val dbResult = repository.findByLongURL(longURL)
        return dbResult?.hash ?: generateHash(longURL)
    }

    private fun generateHash(longURL: String): String {
        val hash = UniqueIdGenerator.getInstance(TimeManagerUtil()).nextId().encode()
        repository.save(URL(hash, longURL))
        return hash
    }
}
