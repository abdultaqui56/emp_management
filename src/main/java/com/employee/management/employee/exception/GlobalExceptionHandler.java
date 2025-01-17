package com.employee.management.employee.exception;

import com.employee.management.salary.exception.GenericServiceException;
import com.employee.management.salary.exception.SalaryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle EmployeesNotFoundException and return 404 with a custom message
    @ExceptionHandler(EmployeesNotFoundException.class)
    public ResponseEntity<String> handleEmployeesNotFoundException(EmployeesNotFoundException ex) {
        // Return a 404 Not Found response with the exception message
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(InvalidDataException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Additional global exception handlers can be added here

    // Handle SalaryNotFoundException
    @ExceptionHandler(SalaryNotFoundException.class)
    public ResponseEntity<String> handleSalaryNotFoundException(SalaryNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Handle GenericServiceException
    @ExceptionHandler(GenericServiceException.class)
    public ResponseEntity<String> handleGenericServiceException(GenericServiceException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
