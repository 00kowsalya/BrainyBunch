package com.example.loanservice_us1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDate issueDate;
    private LocalDate dueDate;

@Enumerated(EnumType.STRING)
    private BookStatus Status = BookStatus.LOANED;
}
