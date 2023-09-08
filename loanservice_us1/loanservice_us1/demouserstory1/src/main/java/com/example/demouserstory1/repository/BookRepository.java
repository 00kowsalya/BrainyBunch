package com.example.demouserstory1.repository;

import com.example.demouserstory1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
