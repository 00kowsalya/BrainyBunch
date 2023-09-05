package com.example.loanservice_us1.service;

import com.example.loanservice_us1.dto.BookDTO;
import com.example.loanservice_us1.entity.Book;
import com.example.loanservice_us1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public  BookDTO saveBook(BookDTO book) {
        Book book1 =new Book();
        book1.setId(book.getId());
        book1.setISBN(book.getISBN());
        book1.setTitle(book.getTitle());
        book1.setPublicationDate(book.getPublicationDate());
        //save
         return saveBook(book);
    }


    public  List<Book> findAllBooks() {
        return bookRepository.findAll();
    }


    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElse(null);

    }
}
