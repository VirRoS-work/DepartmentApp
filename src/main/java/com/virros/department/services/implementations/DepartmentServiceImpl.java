package com.virros.department.services.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.model.dto.DepartmentFondDto;
import com.virros.department.model.dto.mappers.DepartmentMapper;
import com.virros.department.model.entities.Department;
import com.virros.department.services.DepartmentService;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DaoDepartment daoDepartment;

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Optional<DepartmentDto> getDepartmentDto(int id) throws EntityNotFoundException {

        Department department = daoDepartment.getDepartmentById(id).orElseThrow(() ->
        new EntityNotFoundException("Department not found with your id!"));

        return Optional.of(departmentMapper.getDepartmentDtoByDepartment(department));
    }

    @Override
    public List<DepartmentDto> getSubDepartmentsDto(int id) throws EntityNotFoundException {

        Department department = daoDepartment.getDepartmentById(id).orElseThrow(() ->
                new EntityNotFoundException("Department not found with your id!"));

        return department.getSub_departments().stream()
                .map(departmentMapper::getDepartmentDtoByDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public List<DepartmentDto> getSubDepartmentsDtoAll(int id) throws EntityNotFoundException {

        Department department = daoDepartment.getDepartmentById(id).orElseThrow(() ->
                new EntityNotFoundException("Department not found with your id!")
        );

        return getDepartmentAll(department).stream()
                .map(departmentMapper::getDepartmentDtoByDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DepartmentDto> getDepartmentDtoByName(String name) throws EntityNotFoundException{

        Department department = daoDepartment.getDepartmentByName(name).orElseThrow(() ->
                new EntityNotFoundException("Department not found with your name!")
        );

        return Optional.of(departmentMapper.getDepartmentDtoByDepartment(department));
    }

    @Override
    public Optional<DepartmentFondDto> getDepartmentFondDtoById(int id) throws EntityNotFoundException {

        Department department = daoDepartment.getDepartmentById(id).orElseThrow(() ->
                new EntityNotFoundException("Department not found with your id!")
        );

        return Optional.of(departmentMapper.getDepartmentFondDtoByDepartment(department));
    }

    @Override
    public void saveDepartment(DepartmentDto dto) {

    }

    private List<Department> getDepartmentAll(Department department){
        List<Department> departments = new ArrayList<>();

        department.getSub_departments()
                .forEach(dep -> {
                    departments.add(dep);
                    if (!dep.getSub_departments().isEmpty()) departments.addAll(getDepartmentAll(dep));
                });

        return departments;
    }
}
