package com.example.bookapicalling

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.InternalAPI

@OptIn(InternalAPI::class)
suspend fun main() {
    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://books.googleapis.com/books/v1/volumes?q=android")
    println("Response Body :- " + response.bodyAsText())
    println("Response Content :- " + response.content)
    println(response.status)
    client.close()
}