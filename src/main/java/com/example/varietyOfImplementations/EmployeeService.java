package com.example.varietyOfImplementations;

import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    private static final int MaxSize = 2;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String firstName, String lastName){

        if (employees.size()>MaxSize){
            throw new EmployeeStorageIsFullException("Нет места для добавления сотрудника.");
        }
        String key = getKey(firstName, lastName);

        if (employees.containsKey(key)){
            throw new EmployeeAlreadyAddedException("Данный сотрудник уже существует.");
        }

        Employee newEmployee = new Employee(firstName, lastName);
        employees.put(key, newEmployee);
        return newEmployee;
    }

    public Employee remove(String firstName, String lastName){
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Невозможно удалить. Такого сотрудника не существует.");
        }

        Employee employeeForRemove = employees.get(key);

        employees.remove(key);
        return employeeForRemove;
    }

    public Employee find(String firstName, String lastName){
        String key = getKey(firstName, lastName);

        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Такого сотрудника не существует.");
        }

        return employees.get(key);

    }
    public Collection<Employee> getAll(){
        return employees.values();

    }
    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}
