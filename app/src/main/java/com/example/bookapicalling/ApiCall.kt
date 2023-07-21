package com.example.bookapicalling

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.InternalAPI

@OptIn(InternalAPI::class)
suspend fun main() {
    val client = HttpClient(CIO)

    // Get the keyword from the user
    println("Enter the keyword to search for books:")
    val keyword = readLine()

    if (keyword != null && keyword.isNotBlank()) {
        // Construct the API URL with the user-provided keyword
        val apiUrl = "https://books.googleapis.com/books/v1/volumes?q=${keyword.trim()}"

        try {
            val response: HttpResponse = client.get(apiUrl)
            println("Response Body :- " + response.bodyAsText())
            println("Response Content :- " + response.content)
            println(response.status)
        } catch (e: Exception) {
            println("Error occurred: ${e.message}")
        }
    } else {
        println("Invalid keyword. Please enter a valid keyword.")
    }

    client.close()
}
