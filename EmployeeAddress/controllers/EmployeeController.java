package com.mapping.EmployeeAddress.controllers;

import com.mapping.EmployeeAddress.entity.Employee;
import com.mapping.EmployeeAddress.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    //create new employee
    @PostMapping("/employee/create")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmployee){
        return new ResponseEntity<>(employeeRepo.save((newEmployee)), HttpStatus.CREATED);
    }
    //get all employees
    @GetMapping("/get-all-employees")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeRepo.findAll());
    }

    //get by id
    @GetMapping("/get-employee/{id}")
    public ResponseEntity<Employee> getById(@PathVariable int id){
        return ResponseEntity.ok(employeeRepo.findById(id).get());
    }

    //update employee
    @PutMapping("/update-employee/{id}")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee newEmployee, @PathVariable int id){
        Employee existingEmployee = employeeRepo.findById(id).get();
        if(existingEmployee!=null){
            existingEmployee.setEmpId(newEmployee.getEmpId());
            existingEmployee.setFirstName(newEmployee.getFirstName());
            existingEmployee.setLastName(newEmployee.getLastName());
            existingEmployee.setAddress(newEmployee.getAddress());
            employeeRepo.save(existingEmployee);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("UPDATED");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
    }
    //delete by id
    @DeleteMapping("/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id){
        Employee employee = employeeRepo.findById(id).get();
        if(employee!=null){
            employeeRepo.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("DELETED");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND");
        }
    }
}
