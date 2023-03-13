package com.dkb.urlshortner.exception

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class RestResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [InvalidURLException::class])
    protected fun handleInvalidURLException(ex: InvalidURLException, request: WebRequest): ResponseEntity<Any> {
        val bodyOfResponse = "Invalid URL, please provide a valid URL."
        return handleExceptionInternal(
            ex,
            bodyOfResponse,
            HttpHeaders(),
            HttpStatus.BAD_REQUEST,
            request
        )
    }

    @ExceptionHandler(value = [HashNotFoundException::class])
    protected fun handleHashNotFoundException(ex: HashNotFoundException, request: WebRequest): ResponseEntity<Any> {
        val bodyOfResponse = "Given hash doesn't exist in DB."
        return handleExceptionInternal(
            ex,
            bodyOfResponse,
            HttpHeaders(),
            HttpStatus.INTERNAL_SERVER_ERROR,
            request
        )
    }
}