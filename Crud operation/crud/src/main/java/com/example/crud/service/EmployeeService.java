package com.example.crud.service;

import com.example.crud.Exeption.ResourceNotFoundExeption;
import com.example.crud.Repository.EmployeeRepository;
import com.example.crud.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee postEmployee(Employee employee){
        employeeRepository.save(employee);
        return employee;
    }

    public Employee getEmployeeById(Long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Employee not exist with id: " + id));
    }

    public Employee updateEmployeeInfo(Long id, Employee employeeDetails){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Employee not exist with id: " + id));
        employee.setFirstname(employeeDetails.getFirstname());
        employee.setLastname(employeeDetails.getLastname());
        employee.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(employee);
    }

    public Map<String, Boolean> deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Employee not exist with id: " + id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
}
