package com.example.loanservice_us1.repository;

import com.example.loanservice_us1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

}
