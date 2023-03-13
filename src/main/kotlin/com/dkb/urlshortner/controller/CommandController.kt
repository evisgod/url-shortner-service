package com.dkb.urlshortner.controller

import com.dkb.urlshortner.exception.InvalidURLException
import com.dkb.urlshortner.service.CommandUseCase
import org.apache.commons.validator.routines.UrlValidator
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommandController(
    private val command: CommandUseCase
) {

    @PostMapping("/shorten")
    fun shorten(@RequestBody @NotNull url: String): ResponseEntity<Any> {
        if (!UrlValidator.getInstance().isValid(url)) {
            throw InvalidURLException("Please provide a valid URL.")
        }
        return ResponseEntity(command.shortenURL(url), HttpStatus.CREATED)
    }
}
