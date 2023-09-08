package com.example.demouserstory1.entity;

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
    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private BookStatus Status = BookStatus.LOANED;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BookStatus getStatus() {
        return Status;
    }

    public void setStatus(BookStatus status) {
        Status = status;
    }
}
