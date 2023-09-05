package com.example.loanservice_us1.controller;

import com.example.loanservice_us1.dto.BookDTO;
import com.example.loanservice_us1.entity.Book;
import com.example.loanservice_us1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/api/books")
    public class BookController {

        @Autowired
        private BookService bookService;

        @PostMapping
        public BookDTO createBook(@RequestBody BookDTO book) {
            return bookService.saveBook(book);
        }

        @GetMapping
        public List<Book> getAllBooks() {
            return bookService.findAllBooks();
        }

        @GetMapping("/{id}")
        public Book getBookById(@PathVariable Long id) {
            return bookService.findBookById(id);
        }

        // Other endpoints related to books
    }


