package com.example.springkotlinapi.service

import com.example.springkotlinapi.entity.book.Book
import com.example.springkotlinapi.repository.book.BookRepository
import kotlinx.coroutines.flow.toList
import org.springframework.stereotype.Service

//Service é onde fica toda a regra de neógico, metodos (requisições, errors)

@Service
class BookService(
        private val bookRepository: BookRepository
) {
    suspend fun save(book: Book): Book {
        return bookRepository.save(book)
    }

    suspend fun findAllBooks(): List<Book> = bookRepository.findAll().toList()

    suspend fun findByTitle(tile: String): List<Book> = bookRepository.findByTitle(tile)

    suspend fun findById(id: Long): Book {
        return bookRepository.findById(id) ?: throw Exception("Not Found!")
    }

    suspend fun deleteById(id: Long) {
        return bookRepository.deleteById(id)
    }
}