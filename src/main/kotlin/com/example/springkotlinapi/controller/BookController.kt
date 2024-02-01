package com.example.springkotlinapi.controller

import com.example.springkotlinapi.controller.dto.BookRequest
import com.example.springkotlinapi.controller.dto.BookResponse
import com.example.springkotlinapi.controller.dto.toBook
import com.example.springkotlinapi.controller.dto.toBookResponse
import com.example.springkotlinapi.service.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/book")
class BookController(
        private val bookService: BookService
) {

    @PostMapping("/new") //testar sem o new pra ver
    suspend fun save(@RequestBody book: BookRequest): BookResponse {
        return bookService.save(book.toBook()).toBookResponse()
    }

    @GetMapping("/all")
    suspend fun findAllBooks(): List<BookResponse> = bookService.findAllBooks().map { it.toBookResponse() }

    @GetMapping("/id/{id}")
    suspend fun findById(@PathVariable id: Long): BookResponse = bookService.findById(id).toBookResponse()

    @DeleteMapping
    suspend fun deleteById(id: Long) = bookService.deleteById(id)

    @GetMapping("/title/{title}")
    suspend fun findByTitle(@PathVariable title: String): List<BookResponse> = bookService.findByTitle(title).map { it.toBookResponse() }

    //trazer por status
}