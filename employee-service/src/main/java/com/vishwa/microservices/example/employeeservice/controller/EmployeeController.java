package com.vishwa.microservices.example.employeeservice.controller;

import com.vishwa.microservices.example.employeeservice.dto.APIResponseDto;
import com.vishwa.microservices.example.employeeservice.dto.EmployeeDto;
import com.vishwa.microservices.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long id) {
        APIResponseDto employee = employeeService.findEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
