package com.virros.department.services;

import com.virros.department.model.dto.EmployeeDto;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getEmployeesDtoByDepartmentId(int id) throws EntityNotFoundException;

    Optional<EmployeeDto> getEmployeeDto(int id) throws EntityNotFoundException;

    Optional<EmployeeDto> getManagerDtoByEmployee(int id) throws EntityNotFoundException;
}
