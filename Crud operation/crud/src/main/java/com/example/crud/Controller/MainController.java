package com.example.crud.Controller;

import com.example.crud.Repository.EmployeeRepository;
import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MainController {
    private final EmployeeService employeeService;
    @GetMapping("/employees")
    public List<Employee> showHomePage(){
        return employeeService.findAllEmployees();
    }

    @PostMapping(path = "/post")
    public Employee postEmployee(@RequestBody Employee employee){
        return employeeService.postEmployee(employee);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeInfo(@PathVariable Long id, @RequestBody Employee employeeDetails){
        return ResponseEntity.ok(employeeService.updateEmployeeInfo(id, employeeDetails));
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}

