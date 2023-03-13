package com.dkb.urlshortner

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class UrlShortnerServiceApplicationTests {

	@Test
	fun contextLoads(context: ApplicationContext) {
		Assertions.assertNotNull(context)
	}
}
