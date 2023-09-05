package com.example.loanservice_us1.service;

import com.example.loanservice_us1.dto.LoanRecordDTO;
import com.example.loanservice_us1.entity.BookStatus;
import com.example.loanservice_us1.entity.LoanEntity;
import com.example.loanservice_us1.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

        public boolean isBookAvailableForLoan(Long bookId) {
            List<LoanEntity> loanedOrAvailableLoans = loanRepository.findByBookIdAndStatus(bookId, BookStatus.LOANED);
            return loanedOrAvailableLoans.isEmpty();
        }

        // Other loan-related methods


    public LoanEntity issueBook(LoanRecordDTO loanRecordDTO) {
        LoanEntity loanRecord = new LoanEntity();
        loanRecord.setUserId(loanRecordDTO.getUserId());
        loanRecord.setBookId(loanRecordDTO.getBookId());
        loanRecord.setIssueDate(loanRecordDTO.getIssueDate());
        loanRecord.setDueDate(loanRecordDTO.getDueDate());
        LoanEntity saveLoanRecord = loanRepository.save(loanRecord);
        return saveLoanRecord;
    }
}
