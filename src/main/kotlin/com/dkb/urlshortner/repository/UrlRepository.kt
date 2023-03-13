package com.dkb.urlshortner.repository

import com.dkb.urlshortner.entity.URL
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlRepository : JpaRepository<URL, Long> {
    fun findByLongURL(longURL: String): URL?
    fun findByHash(hash: String): URL?
}