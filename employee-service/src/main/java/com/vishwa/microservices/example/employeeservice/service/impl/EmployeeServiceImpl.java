package com.vishwa.microservices.example.employeeservice.service.impl;

import com.vishwa.microservices.example.employeeservice.dto.APIResponseDto;
import com.vishwa.microservices.example.employeeservice.dto.DepartmentDto;
import com.vishwa.microservices.example.employeeservice.dto.EmployeeDto;
import com.vishwa.microservices.example.employeeservice.entity.Employee;
import com.vishwa.microservices.example.employeeservice.mapper.EmployeeMapper;
import com.vishwa.microservices.example.employeeservice.repository.EmployeeRepository;
import com.vishwa.microservices.example.employeeservice.service.APIClient;
import com.vishwa.microservices.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // private RestTemplate restTemplate;

    // private WebClient webClient;

    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDto);
        employeeRepository.save(newEmployee);
        return EmployeeMapper.mapToEmployeeDto(newEmployee);
    }

    @Override
    public APIResponseDto findEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        // REST Template
        //ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/find/" + employee.getDepartmentCode(), DepartmentDto.class);
        // DepartmentDto departmentDto = responseEntity.getBody();

        // WebClient
        // DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/find/" + employee.getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();

        DepartmentDto departmentDto = apiClient.getDepartment(employeeDto.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto;
    }
}
