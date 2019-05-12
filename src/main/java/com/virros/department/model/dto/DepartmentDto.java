package com.virros.department.model.dto;

import java.time.LocalDate;

public class DepartmentDto {

    private Integer id;

    private String name;

    private LocalDate creation_date;

    private EmployeeDto department_head;

    private Integer number_of_employees;

    public DepartmentDto() {
    }

    public DepartmentDto(Integer id, String name, LocalDate creation_date, EmployeeDto department_head, Integer number_of_employees) {
        this.id = id;
        this.name = name;
        this.creation_date = creation_date;
        this.department_head = department_head;
        this.number_of_employees = number_of_employees;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation_date=" + creation_date +
                ", department_head=" + department_head +
                ", number_of_employees=" + number_of_employees +
                '}';
    }
}
