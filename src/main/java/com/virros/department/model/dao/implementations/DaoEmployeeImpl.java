package com.virros.department.model.dao.implementations;

import com.virros.department.model.dao.DaoEmployee;
import com.virros.department.model.entities.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DaoEmployeeImpl implements DaoEmployee{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveEmployee(Employee employee) {

    }

    @Override
    public Optional<Employee> getEmployeeById(Integer id) {
        return Optional.of(getSession().get(Employee.class, id));
    }

    @Override
    public Optional<Employee> getEmployeeByPosition(String position) {
        return null;
    }

    private Session getSession(){
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session;
    }
}
