package com.dkb.urlshortner

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
class UrlShortnerServiceApplication

fun main(args: Array<String>) {
    runApplication<UrlShortnerServiceApplication>(*args)
}
