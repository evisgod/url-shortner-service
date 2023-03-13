package com.dkb.urlshortner.controller

import io.restassured.RestAssured
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class QueryControllerTest {
    @LocalServerPort
    var port: Int = 0

    @BeforeAll
    fun beforeAll() {
        RestAssured.port = port
    }

    @Test
    fun `should return long url for a hash`() {
        val result = RestAssured.given()
            .get("/VUS6rpcIK")
            .then()
            .statusCode(302)
            .extract()
            .asString()
        assertEquals("https://www.google.com", result)
    }
}