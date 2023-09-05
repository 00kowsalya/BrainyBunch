package com.example.loanservice_us1.dto;

import com.example.loanservice_us1.entity.BookStatus;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String ISBN;
    private Date publicationDate;

}
