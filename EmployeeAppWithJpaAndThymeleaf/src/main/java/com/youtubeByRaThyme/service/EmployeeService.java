package com.youtubeByRaThyme.service;

import com.youtubeByRaThyme.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee>getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
