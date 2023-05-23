package com.vishwa.microservices.example.departmentservice.service.impl;

import com.vishwa.microservices.example.departmentservice.dto.DepartmentDto;
import com.vishwa.microservices.example.departmentservice.entity.Department;
import com.vishwa.microservices.example.departmentservice.mapper.DepartmentMapper;
import com.vishwa.microservices.example.departmentservice.repository.DepartmentRepository;
import com.vishwa.microservices.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department saveDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartment = DepartmentMapper.mapToDepartmentDto(saveDepartment);
        return savedDepartment;
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
