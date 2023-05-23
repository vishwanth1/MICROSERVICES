package com.vishwa.microservices.example.employeeservice.repository;

import com.vishwa.microservices.example.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
