package com.virros.department.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private LocalDate creation_date;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Department parent_department;

//    @OneToMany(mappedBy = "department")
//    private List<Employee> employees;

    public Department() {
    }

    public Department(String name, LocalDate creation_date, Department parent_department, List<Employee> employees) {
        this.name = name;
        this.creation_date = creation_date;
        this.parent_department = parent_department;
//        this.employees = employees;
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

    public LocalDate getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(LocalDate creation_date) {
        this.creation_date = creation_date;
    }

    public Department getParent_department() {
        return parent_department;
    }

    public void setParent_department(Department parent_department) {
        this.parent_department = parent_department;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creation_date=" + creation_date +
//                ", employees=" + employees +
                '}';
    }
}
