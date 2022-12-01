package com.example.plugins

import com.example.core.hasAnagrams
import com.example.utils.isValidated
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    routing {
        post("/compare") {
            val words = call.parameters[KEY_words] ?: return@post
            val list = words.split('_').map { it.trim() }
            if (!list.isValidated()) {
                call.respondText("Invalid input type")
                return@post
            }
            val result = hasAnagrams(list)
            call.respondText("$result")
        }
    }
}

private const val KEY_words = "words"
