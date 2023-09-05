package com.example.loanservice_us1.repository;

import com.example.loanservice_us1.entity.BookStatus;
import com.example.loanservice_us1.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<LoanEntity,Long> {
    List<LoanEntity>findByBookIdAndStatus(Long bookId , BookStatus Status) ;
}
