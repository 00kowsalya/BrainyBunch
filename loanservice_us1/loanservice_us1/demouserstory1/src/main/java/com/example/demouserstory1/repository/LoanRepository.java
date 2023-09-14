package com.example.demouserstory1.repository;

import com.example.demouserstory1.entity.BookStatus;
import com.example.demouserstory1.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity,Long> {
  /*  List<LoanEntity> findByBookIdAndStatus(Long bookId , BookStatus Status) ;*/


    List<LoanEntity> findByUserId(Long userId);

    LoanEntity findByBookId(Long bookId);
}
