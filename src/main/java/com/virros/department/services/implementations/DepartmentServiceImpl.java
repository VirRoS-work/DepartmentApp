package com.virros.department.services.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.entities.Department;
import com.virros.department.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DaoDepartment daoDepartment;

    @Override
    public Department getDepartment(int id) {
        return daoDepartment.getDepartment(id);
    }
}
