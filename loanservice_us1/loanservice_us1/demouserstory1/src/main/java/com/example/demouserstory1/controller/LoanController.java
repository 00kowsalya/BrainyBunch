package com.example.demouserstory1.controller;

import com.example.demouserstory1.dto.LoanRecordDTO;
import com.example.demouserstory1.entity.LoanEntity;
import com.example.demouserstory1.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

/*
    @GetMapping("/check-availablity")
    public ResponseEntity<String> checkAvailablityForLoan(@RequestBody LoanRecordDTO loanRecordDTO)
    {
        if(loanService.isBookAvailableForLoan(loanRecordDTO.getBookId())){
            return(ResponseEntity.ok("Book is available for loan."));
        }else {
            return ResponseEntity.badRequest().body("Book is not available for loan.");

        }
    }*/
    @GetMapping("/users/{userId}")
    public List<LoanEntity> getLoanRecordsForUser(@PathVariable Long userId) {
        return loanService.getLoanRecords(userId);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getLoanRecordForBook(@PathVariable Long userId, @RequestParam(required = true) Long bookId) {
        try {
            return loanService.getLoanRecord(bookId);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
