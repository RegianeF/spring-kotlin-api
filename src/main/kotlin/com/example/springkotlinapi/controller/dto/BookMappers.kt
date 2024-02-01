package com.example.springkotlinapi.controller.dto

import com.example.springkotlinapi.entity.book.Book

fun BookRequest.toBook(): Book {
    return Book(
            title = title,
            status = status
    )
}

fun Book.toBookResponse() : BookResponse {
    return BookResponse(
            id = id ?: -1,
            title = title,
            status = status
    )
}