package com.dkb.urlshortner.controller

import com.dkb.urlshortner.service.QueryUseCase
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class QueryController(
    private val query: QueryUseCase
) {

    @GetMapping("/{hash}")
    fun getLongURL(@PathVariable hash: String): ResponseEntity<Any> {
        return ResponseEntity(query.getLongURL(hash), HttpStatus.FOUND)
    }
}
