package com.virros.department.model.dto.mappers;

import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.model.dto.DepartmentFondDto;
import com.virros.department.model.dto.EmployeeDto;
import com.virros.department.model.entities.Department;
import com.virros.department.model.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDto getDepartmentDtoByDepartment(Department department) {

        DepartmentDto result = new DepartmentDto();

        result.setId(department.getId());
        result.setName(department.getName());
        result.setCreation_date(department.getCreation_date());
        result.setDepartment_head(
                department.getEmployees().stream().filter(Employee::isDepartment_head).count() > 0
                        ? new EmployeeDto(department.getEmployees().stream().filter(Employee::isDepartment_head).findFirst().get())
                        : null
        );
        result.setNumber_of_employees(department.getEmployees().size());

        return result;
    }

    public DepartmentFondDto getDepartmentFondDtoByDepartment(Department department) {

        DepartmentFondDto result = new DepartmentFondDto();

        result.setId(department.getId());
        result.setName(department.getName());
        result.setFond(department.getEmployees().stream().mapToInt(Employee::getSalary).sum());
        result.setNumber_of_employees(department.getEmployees().size());

        return result;
    }


}
