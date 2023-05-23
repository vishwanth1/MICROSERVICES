package com.vishwa.microservices.example.employeeservice.service;

import com.vishwa.microservices.example.employeeservice.dto.APIResponseDto;
import com.vishwa.microservices.example.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto findEmployee(Long id);
}
