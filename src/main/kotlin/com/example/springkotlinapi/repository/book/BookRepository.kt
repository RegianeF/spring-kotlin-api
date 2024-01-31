package com.example.springkotlinapi.repository.book

import com.example.springkotlinapi.entity.book.Book
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : CoroutineCrudRepository<Book, Long?> {

    @Query("SELECT * FROM application.books WHERE title = :title")
    suspend fun findByTitle(tile: String) : List<Book>

}