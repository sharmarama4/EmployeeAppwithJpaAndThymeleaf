package com.youtubeByRaThyme.service.implementetion;

import com.youtubeByRaThyme.entity.Employee;
import com.youtubeByRaThyme.repository.EmployeeRepository;
import com.youtubeByRaThyme.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
       this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
   Optional optional=employeeRepository.findById(id);

        if (optional.isPresent()){
            return(Employee)optional.get();

        }
        return null;
    }

    @Override
    public void deleteEmployeeById(long id) {
        employeeRepository.deleteById(id);
    }

}

