package com.example.springkotlinapi.entity.book

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "books", schema = "application")
data class Book(
        @Id
        val id: Long? = null,
        val title: String,
        val status: Boolean
)
