package com.virros.department.services.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.dao.DaoEmployee;
import com.virros.department.model.dto.EmployeeDto;
import com.virros.department.model.dto.mappers.EmployeeMapper;
import com.virros.department.model.entities.Department;
import com.virros.department.model.entities.Employee;
import com.virros.department.services.EmployeeService;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    DaoEmployee daoEmployee;

    @Autowired
    DaoDepartment daoDepartment;

    @Autowired
    EmployeeMapper mapper;

    @Override
    public List<EmployeeDto> getEmployeesDtoByDepartmentId(int id) throws EntityNotFoundException {

        Department department = daoDepartment.getDepartmentById(id).orElseThrow(() ->
                new EntityNotFoundException("Department not found with your id!"));

        return department.getEmployees().stream()
                .map(mapper::getEmployeeDtoByEmployee)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDto> getEmployeeDto(int id) throws EntityNotFoundException {

        Employee employee = daoEmployee.getEmployeeById(id).orElseThrow(() ->
                new EntityNotFoundException("Employee not found with your id!"));

        return Optional.of(mapper.getEmployeeDtoByEmployee(employee));
    }

    @Override
    public Optional<EmployeeDto> getManagerDtoByEmployee(int id) throws EntityNotFoundException {

        Employee employee = daoEmployee.getEmployeeById(id).orElseThrow(() ->
                new EntityNotFoundException("Employee not found with your id!"));

        if (employee.getDepartment() == null) throw new EntityNotFoundException("Employee haven`t department!");

        return employee.getDepartment().getEmployees().stream().filter(Employee::isDepartment_head).count() > 0
                ? Optional.of(new EmployeeDto(employee.getDepartment().getEmployees().stream()
                .filter(Employee::isDepartment_head).findFirst().get()))
                : Optional.empty();
    }
}
