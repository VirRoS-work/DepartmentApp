package com.virros.department.services.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.model.entities.Department;
import com.virros.department.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DaoDepartment daoDepartment;

    @Override
    public Optional<DepartmentDto> getDepartmentDto(int id) {

        Optional<Department> department = daoDepartment.getDepartmentById(id);

        return Optional.ofNullable(department.map(DepartmentDto::new).orElse(null));
    }

    @Override
    public Optional<DepartmentDto> getDepartmentDtoByName(String name) {
        return null;
    }

    @Override
    public void saveDepartment(DepartmentDto dto) {

    }
}
