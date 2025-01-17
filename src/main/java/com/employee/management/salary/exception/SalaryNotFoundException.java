package com.employee.management.salary.exception;


public class SalaryNotFoundException extends RuntimeException {
    public SalaryNotFoundException(String message) {
        super(message);
    }
}

