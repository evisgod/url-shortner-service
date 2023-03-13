package com.dkb.urlshortner.controller

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CommandControllerTest {
    @LocalServerPort
    var port: Int = 0

    @BeforeAll
    fun beforeAll() {
        RestAssured.port = port
    }

    @Test
    fun `should return hash for a valid url`() {
        val result = given()
            .body("https://www.google.com")
            .post("/shorten")
            .then()
            .statusCode(201)
            .extract()
            .asString()
        assertEquals("VUS6rpcIK", result)
    }

    @Test
    fun `should return http 400 for an invalid url`() {
        given()
            .body("/invalidurl.com")
            .post("/shorten")
            .then()
            .statusCode(400)
    }
}