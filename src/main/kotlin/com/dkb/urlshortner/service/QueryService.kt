package com.dkb.urlshortner.service

import com.dkb.urlshortner.exception.HashNotFoundException
import com.dkb.urlshortner.repository.UrlRepository
import org.springframework.stereotype.Service

@Service
class QueryService(
    private val repository: UrlRepository
) : QueryUseCase {
    override fun getLongURL(hash: String): String {
        val dbResult = repository.findByHash(hash)
        return dbResult?.longURL ?: throw HashNotFoundException("Given Hash not found in db!")
    }
}
