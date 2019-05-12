package com.virros.department.services;

import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.model.dto.DepartmentFondDto;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    Optional<DepartmentDto> getDepartmentDto(int id) throws EntityNotFoundException;

    List<DepartmentDto> getSubDepartmentsDto(int id) throws EntityNotFoundException;

    List<DepartmentDto> getSubDepartmentsDtoAll(int id) throws EntityNotFoundException;

    Optional<DepartmentDto> getDepartmentDtoByName(String name) throws EntityNotFoundException;

    Optional<DepartmentFondDto> getDepartmentFondDtoById(int id) throws EntityNotFoundException;

    void saveDepartment(DepartmentDto dto);
}
