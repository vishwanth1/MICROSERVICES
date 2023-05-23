package com.vishwa.microservices.example.employeeservice.service;

import com.vishwa.microservices.example.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {

    @GetMapping("api/departments/find/{departmentCode}")
    DepartmentDto getDepartment(@PathVariable String departmentCode);
}
