package com.example.demouserstory1.service;

import com.example.demouserstory1.dto.LoanRecordDTO;
import com.example.demouserstory1.dto.UserRegistrationRequest;
import com.example.demouserstory1.entity.Book;
import com.example.demouserstory1.entity.BookStatus;
import com.example.demouserstory1.entity.LoanEntity;
import com.example.demouserstory1.entity.UserEntity;
import com.example.demouserstory1.repository.BookRepository;
import com.example.demouserstory1.repository.LoanRepository;
import com.example.demouserstory1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.example.demouserstory1.entity.BookStatus.LOANED;



@Service
public class LoanService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    private BookStatus bookStatus;

   /* public boolean isBookAvailableForLoan(Long bookId) {
        List<LoanEntity> loanedOrAvailableLoans = loanRepository.findByBookIdAndStatus(bookId, LOANED);
        return loanedOrAvailableLoans.isEmpty();
    }*/

    // Other loan-related methods


    public LoanEntity issueBook(LoanRecordDTO loanRecordDTO) {
        LoanEntity loanRecord = new LoanEntity();
        loanRecord.setUserId(loanRecordDTO.getUserId());
        loanRecord.setBookId(loanRecordDTO.getBookId());
        loanRecord.setIssueDate(LocalDate.now());
        loanRecord.setDueDate(LocalDate.now().plusDays(14));
        LoanEntity saveLoanRecord = loanRepository.save(loanRecord);
        return saveLoanRecord;
    }

    public List<LoanEntity> getLoanRecords(Long userId) {
        List<LoanEntity> loanRecords = loanRepository.findByUserId(userId);
        return loanRecords;
    }

    public ResponseEntity<?> getLoanRecord(Long bookId) {
        LoanEntity loanRecord = loanRepository.findByBookId(bookId);
        return new ResponseEntity<>(loanRecord.getDueDate(), HttpStatus.OK);
    }

    public ResponseEntity<?> issue(LoanEntity loan) {
        UserEntity userEntity = userRepository.findById(loan.getUserId()).orElse(null);
        List<LoanEntity> loanRecords = loanRepository.findByUserId(userEntity.getId());
        int limit = 4;
        Book book = bookRepository.findById(loan.getBookId()).orElse(null);
        if (loanRecords.size() < limit && BookStatus.AVAILABlE == book.getStatus()) {
            LoanEntity loanRecord = LoanEntity.builder()
                    .userId(loan.getId())
                    .bookId(loan.getBookId())
                    .issueDate(LocalDate.now())
                    .dueDate(LocalDate.now().plusDays(14))
                    .build();
            book.setTitle(book.getTitle());
            book.setISBN(book.getISBN());
            book.setStatus(LOANED);
            bookRepository.save(book);
            return ResponseEntity.ok(loanRepository.save(loanRecord));
        }
        return new ResponseEntity<>(new IllegalArgumentException("book is not available for loan or Exc"), HttpStatus.UNAUTHORIZED);
    }


}
