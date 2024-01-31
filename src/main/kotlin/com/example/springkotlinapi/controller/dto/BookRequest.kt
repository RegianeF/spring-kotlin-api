package com.example.springkotlinapi.controller.dto

import com.example.springkotlinapi.entity.book.Book

data class BookRequest(
        val title: String,
        val status: Book
)
