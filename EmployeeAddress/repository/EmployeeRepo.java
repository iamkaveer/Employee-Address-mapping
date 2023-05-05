package com.mapping.EmployeeAddress.repository;

import com.mapping.EmployeeAddress.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
}
