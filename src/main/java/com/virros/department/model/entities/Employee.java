package com.virros.department.model.entities;

import com.virros.department.model.types.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;

    private String last_name;

    private String father_name;

    @Enumerated(EnumType.STRING)
    private Gender empl_gender;

    private LocalDate birthday;

    private String contact_phone;

    private String email;

    private LocalDate date_work_start;

    private LocalDate date_work_end;

    private String position;

    private Integer salary;

    private boolean department_head;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "department_id")
//    private Department department;

    public Employee() {
    }

    public Employee(String first_name, String last_name, String father_name, Gender empl_gender, LocalDate birthday,
                    String contact_phone, String email, LocalDate date_work_start, LocalDate date_work_end,
                    String position, Integer salary, boolean department_head, Department department) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.father_name = father_name;
        this.empl_gender = empl_gender;
        this.birthday = birthday;
        this.contact_phone = contact_phone;
        this.email = email;
        this.date_work_start = date_work_start;
        this.date_work_end = date_work_end;
        this.position = position;
        this.salary = salary;
        this.department_head = department_head;
//        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public Gender getEmpl_gender() {
        return empl_gender;
    }

    public void setEmpl_gender(Gender empl_gender) {
        this.empl_gender = empl_gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate_work_start() {
        return date_work_start;
    }

    public void setDate_work_start(LocalDate date_work_start) {
        this.date_work_start = date_work_start;
    }

    public LocalDate getDate_work_end() {
        return date_work_end;
    }

    public void setDate_work_end(LocalDate date_work_end) {
        this.date_work_end = date_work_end;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public boolean isDepartment_head() {
        return department_head;
    }

    public void setDepartment_head(boolean department_head) {
        this.department_head = department_head;
    }

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", father_name='" + father_name + '\'' +
                ", empl_gender=" + empl_gender +
                ", birthday=" + birthday +
                ", contact_phone='" + contact_phone + '\'' +
                ", email='" + email + '\'' +
                ", date_work_start=" + date_work_start +
                ", date_work_end=" + date_work_end +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", department_head=" + department_head +
                '}';
    }
}
