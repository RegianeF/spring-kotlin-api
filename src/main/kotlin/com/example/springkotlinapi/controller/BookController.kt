package com.example.springkotlinapi.controller

import com.example.springkotlinapi.entity.book.Book
import com.example.springkotlinapi.service.BookService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/book")
class BookController(
        private val bookService: BookService
) {

    @PostMapping("/new") //testar sem o new pra ver
    suspend fun save(@RequestBody book: Book): Book {
        return bookService.save(book)
    }

    @PostMapping("/find_all_book")
    suspend fun findAllBooks(): List<Book> = bookService.findAllBooks()

    suspend fun findByTitle(tile: String): List<Book> = bookService.findByTitle(tile)

    suspend fun findById(id: Long): Book = bookService.findById(id)

    suspend fun deleteById(id: Long) = bookService.deleteById(id)

}