package com.vishwa.microservices.example.departmentservice.service;

import com.vishwa.microservices.example.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    public DepartmentDto saveDepartment(DepartmentDto departmentDto);

    public DepartmentDto getDepartment(String departmentCode);
}
