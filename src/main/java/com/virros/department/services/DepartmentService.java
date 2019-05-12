package com.virros.department.services;

import com.virros.department.model.dto.DepartmentDto;

import java.util.Optional;

public interface DepartmentService {

    Optional<DepartmentDto> getDepartmentDto(int id);

    Optional<DepartmentDto> getDepartmentDtoByName(String name);

    void saveDepartment(DepartmentDto dto);
}
