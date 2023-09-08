package com.example.varietyOfImplementations;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int MaxSize = 2;
    private final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName, lastName);
        if (employees.contains(newEmployee)){
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже существует.");
        }
        if (employees.size()>MaxSize){
            throw new EmployeeStorageIsFullException("Нет места для добавления сотрудника.");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public Employee remove(String firstName, String lastName){
        Employee removeEmployee = new Employee(firstName, lastName);
        if (!employees.contains(removeEmployee)){
            throw new EmployeeNotFoundException("Невозможно удалить, данный сотрудник не найден.");}
        employees.remove(removeEmployee);
        return removeEmployee;
    }

    public Employee find(String firstName, String lastName){
        Employee findEmployee = new Employee(firstName, lastName);
        if (employees.contains(findEmployee)){
            return findEmployee;}
        else {
            throw new EmployeeNotFoundException("Данный сотрудник не найден.");
        }

    }
    public List<Employee> getAll(){
        return employees;

    }
}
