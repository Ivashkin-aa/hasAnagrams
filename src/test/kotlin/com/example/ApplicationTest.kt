package com.example

import com.example.plugins.configureRouting
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.post("/compare?words=tac_light_cat").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("true", bodyAsText())
        }
    }

    @Test
    fun testError() = testApplication {
        application {
            configureRouting()
        }
        client.post("/compare").apply {
            assertEquals(HttpStatusCode.NotFound, status)
        }
    }

    @Test
    fun testInputInvalid() = testApplication {
        application {
            configureRouting()
        }
        client.post("/compare?words=").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Invalid input type", bodyAsText())
        }
    }
}