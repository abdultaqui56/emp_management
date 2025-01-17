package com.employee.management.employee.exception;

public class EmployeesNotFoundException extends RuntimeException {

    public EmployeesNotFoundException(String message) {
        super(message);
    }
}
