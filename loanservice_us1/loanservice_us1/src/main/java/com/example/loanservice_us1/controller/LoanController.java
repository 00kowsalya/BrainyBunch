package com.example.loanservice_us1.controller;

import com.example.loanservice_us1.dto.LoanRecordDTO;
import com.example.loanservice_us1.entity.Book;
import com.example.loanservice_us1.entity.LoanEntity;
import com.example.loanservice_us1.entity.UserEntity;
import com.example.loanservice_us1.service.LoanService;
import com.example.loanservice_us1.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

@Autowired
private LoanService loanService;

    @PostMapping("/issue")
    public LoanEntity issueBook(@RequestBody LoanRecordDTO loanRecordDTO)
    {
        return loanService.issueBook(loanRecordDTO);
    }

    @GetMapping("/check-limits/{userId}")
            public ResponseEntity<String>checkLoanLimits(@PathVariable Long userId){


    }
@GetMapping
    public List<LoanEntity> retrieveuser() {
        return bookService.findAllBooks();
    }


    @GetMapping("/check-availablity")
    public ResponseEntity<String>checkAvailablityForLoan(@RequestBody LoanRecordDTO loanRecordDTO)
    {
        if(loanService.isBookAvailableForLoan(loanRecordDTO.getBookId())){
            return(ResponseEntity.ok("Book is available for loan."));
    }else {
            return ResponseEntity.badRequest().body("Book is not available for loan.");

        }
    }

}
