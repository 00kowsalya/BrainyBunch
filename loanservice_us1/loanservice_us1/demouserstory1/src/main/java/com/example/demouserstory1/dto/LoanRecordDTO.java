package com.example.demouserstory1.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class LoanRecordDTO {
    private Long bookId;
    private Long userId;
    private LocalDate issueDate;
    private LocalDate dueDate;

}
