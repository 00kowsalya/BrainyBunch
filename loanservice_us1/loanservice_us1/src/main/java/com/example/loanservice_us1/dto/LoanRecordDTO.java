package com.example.loanservice_us1.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;
@Getter
@Setter
public class LoanRecordDTO {
    private Long bookId;
    private Long userId;
    private LocalDate issueDate;
    private LocalDate dueDate;

}
