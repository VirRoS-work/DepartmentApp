package com.virros.department.model.dao;

import com.virros.department.model.entities.Employee;

import java.util.Optional;

public interface DaoEmployee {

    void saveEmployee(Employee employee);

    Optional<Employee> getEmployeeById(Integer id);

    Optional<Employee> getEmployeeByPosition(String position);

}
