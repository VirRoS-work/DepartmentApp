package com.virros.department.controllers;

import com.virros.department.model.dto.EmployeeDto;
import com.virros.department.services.EmployeeService;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
@Api(value = "Сотрудники", description = "Контроллер обеспечивает работу с сотрудниками")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping(value = "/department_employees/{id}")
    @ApiOperation("E1 / Получение списка сотрудников департамента.")
    public ResponseEntity<?> getEmployeesByDepartment(@PathVariable Integer id) throws EntityNotFoundException {

        List<EmployeeDto> result = service.getEmployeesDtoByDepartmentId(id);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation("E5 / Получение информации о сотруднике.")
    public ResponseEntity<?> getEmployeesById(@PathVariable Integer id) throws EntityNotFoundException {

        EmployeeDto result = service.getEmployeeDto(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}/manager")
    @ApiOperation("E8 / Получение информации о руководителе данного сотрудника.")
    public ResponseEntity<?> getManagerByEmployee(@PathVariable Integer id) throws EntityNotFoundException {

        EmployeeDto result = service.getManagerDtoByEmployee(id).orElse(null);

        return ResponseEntity.ok().body(result);
    }

    
}
