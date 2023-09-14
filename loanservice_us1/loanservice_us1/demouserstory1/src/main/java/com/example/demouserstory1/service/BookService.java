package com.example.demouserstory1.service;
import com.example.demouserstory1.dto.BookDTO;
import com.example.demouserstory1.entity.Book;
import com.example.demouserstory1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {
        @Autowired
        private   BookRepository bookRepository;

        public Book saveBook(BookDTO bookDTO) {
            Book book1 = new Book();
            book1.setTitle(bookDTO.getTitle());
            book1.setISBN(bookDTO.getISBN());
            book1.setPublicationDate(bookDTO.getPublicationDate());
            //save
            return bookRepository.save(book1);
        }


        public List<Book> findAllBooks() {
            return bookRepository.findAll();
        }


        public Book findBookById(Long id) {
            return bookRepository.findById(id).orElse(null);

        }

    }


