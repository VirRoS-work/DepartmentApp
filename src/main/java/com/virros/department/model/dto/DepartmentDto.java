package com.virros.department.model.dto;

import com.virros.department.model.entities.Department;
import com.virros.department.model.entities.Employee;

import java.time.LocalDate;

public class DepartmentDto {

    private String name;

    private LocalDate creation_date;

    private EmployeeDto department_head;

    private Integer number_of_employees;

    public DepartmentDto() {
    }

    public DepartmentDto(String name, LocalDate creation_date, EmployeeDto department_head, Integer number_of_employees) {
        this.name = name;
        this.creation_date = creation_date;
        this.department_head = department_head;
        this.number_of_employees = number_of_employees;
    }

    public DepartmentDto(Department department){
        this.name = department.getName();
        this.creation_date = department.getCreation_date();
        this.department_head = department.getEmployees().stream().filter(Employee::isDepartment_head).count() > 0
                ? new EmployeeDto(department.getEmployees().stream().filter(Employee::isDepartment_head).findFirst().get())
                : null;
        this.number_of_employees = department.getEmployees().size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public EmployeeDto getDepartment_head() {
        return department_head;
    }

    public void setDepartment_head(EmployeeDto department_head) {
        this.department_head = department_head;
    }

    public Integer getNumber_of_employees() {
        return number_of_employees;
    }

    public void setNumber_of_employees(Integer number_of_employees) {
        this.number_of_employees = number_of_employees;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "name='" + name + '\'' +
                ", creation_date=" + creation_date +
                ", department_head=" + department_head +
                ", number_of_employees=" + number_of_employees +
                '}';
    }
}
