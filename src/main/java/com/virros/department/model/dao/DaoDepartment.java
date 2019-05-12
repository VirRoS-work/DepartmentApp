package com.virros.department.model.dao;

import com.virros.department.model.entities.Department;

import java.util.Optional;

public interface DaoDepartment {

    void saveDepartment(Department department);

    void deleteDepartment(Integer id);

    Optional<Department> getDepartmentById(Integer id);

    Optional<Department> getDepartmentByName(String name);

}
