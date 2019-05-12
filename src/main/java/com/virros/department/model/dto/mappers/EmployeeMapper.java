package com.virros.department.model.dto.mappers;

import com.virros.department.model.dto.EmployeeDto;
import com.virros.department.model.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDto getEmployeeDtoByEmployee(Employee employee) {

        EmployeeDto result = new EmployeeDto();

        result.setFirst_name(employee.getFirst_name());
        result.setLast_name(employee.getLast_name());
        result.setFather_name(employee.getFather_name());
        result.setEmpl_gender(employee.getEmpl_gender());
        result.setBirthday(employee.getBirthday());
        result.setContact_phone(employee.getContact_phone());
        result.setEmail(employee.getEmail());
        result.setDate_work_start(employee.getDate_work_start());
        result.setDate_work_end(employee.getDate_work_end());
        result.setPosition(employee.getPosition());
        result.setSalary(employee.getSalary());

        return result;
    }
}
