package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponse{
    private String message;
    public int status;
    public LocalDateTime dateTime;
}
