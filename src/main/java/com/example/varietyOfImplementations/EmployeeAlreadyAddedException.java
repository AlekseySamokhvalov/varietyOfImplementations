package com.example.varietyOfImplementations;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException(String s) {
        super(s);
    }
}
