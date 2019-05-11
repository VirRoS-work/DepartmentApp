package com.virros.department.services.implementations;

import com.virros.department.model.dao.DaoDepartment;
import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DaoDepartment daoDepartment;

    @Override
    public DepartmentDto getDepartmentDto(int id) {
        return new DepartmentDto(daoDepartment.getDepartment(id));
    }
}
