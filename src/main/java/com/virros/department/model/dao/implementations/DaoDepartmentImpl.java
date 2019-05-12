package com.virros.department.model.dao.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.entities.Department;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Repository
public class DaoDepartmentImpl implements DaoDepartment {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveDepartment(Department department) {

    }

    @Override
    public void deleteDepartment(Department department) {
        getSession().delete(department);
    }

    @Override
    public Optional<Department> getDepartmentById(Integer id) {

        return Optional.ofNullable(getSession().get(Department.class, id));
    }

    @Override
    public Optional<Department> getDepartmentByName(String name) {

        Session session = getSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Department> query = criteriaBuilder.createQuery(Department.class);
        Root<Department> root = query.from(Department.class);
        query.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        Query q = session.createQuery(query);

        try{
            Department result = (Department) q.getSingleResult();
            return Optional.of(result);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
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
