package com.example.varietyOfImplementations;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException(String s) {
        super(s);
    }
}
