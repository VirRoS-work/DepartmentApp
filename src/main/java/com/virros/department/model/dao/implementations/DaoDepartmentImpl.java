package com.virros.department.model.dao.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.entities.Department;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoDepartmentImpl implements DaoDepartment {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Department getDepartment(Integer id) {
        Session session;

        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }

        return session.get(Department.class, id);
    }
}
