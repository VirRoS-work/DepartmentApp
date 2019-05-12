package com.virros.department.model.dto;

public class DepartmentFondDto {

    private Integer id;

    private String name;

    private Integer fond;

    private Integer number_of_employees;

    public DepartmentFondDto() {
    }

    public DepartmentFondDto(Integer id, String name, Integer fond, Integer number_of_employees) {
        this.id = id;
        this.name = name;
        this.fond = fond;
        this.number_of_employees = number_of_employees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFond() {
        return fond;
    }

    public void setFond(Integer fond) {
        this.fond = fond;
    }

    public Integer getNumber_of_employees() {
        return number_of_employees;
    }

    public void setNumber_of_employees(Integer number_of_employees) {
        this.number_of_employees = number_of_employees;
    }

    @Override
    public String toString() {
        return "DepartmentFondDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fond=" + fond +
                ", number_of_employees=" + number_of_employees +
                '}';
    }
}
