package com.virros.department.model.dto;

import com.virros.department.model.entities.Employee;
import com.virros.department.model.types.Gender;

import java.time.LocalDate;

public class EmployeeDto {

    private String first_name;

    private String last_name;

    private String father_name;

    private Gender empl_gender;

    private LocalDate birthday;

    private String contact_phone;

    private String email;

    private LocalDate date_work_start;

    private LocalDate date_work_end;

    private String position;

    private Integer salary;

    public EmployeeDto() {
    }

    public EmployeeDto(String first_name, String last_name, String father_name, Gender empl_gender,
                       LocalDate birthday, String contact_phone, String email, LocalDate date_work_start,
                       LocalDate date_work_end, String position, Integer salary) {
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
    }

    public EmployeeDto(Employee employee){
        this.first_name = employee.getFirst_name();
        this.last_name = employee.getLast_name();
        this.father_name = employee.getFather_name();
        this.empl_gender = employee.getEmpl_gender();
        this.birthday = employee.getBirthday();
        this.contact_phone = employee.getContact_phone();
        this.email = employee.getEmail();
        this.date_work_start = employee.getDate_work_start();
        this.date_work_end = employee.getDate_work_end();
        this.position = employee.getPosition();
        this.salary = employee.getSalary();
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

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "first_name='" + first_name + '\'' +
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
                '}';
    }
}
