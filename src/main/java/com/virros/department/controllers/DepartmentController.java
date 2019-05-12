package com.virros.department.controllers;

import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.services.DepartmentService;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    //D4

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getInformationAboutDepartment(@PathVariable Integer id) throws EntityNotFoundException {

        DepartmentDto result = service.getDepartmentDto(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Department not found!")
                );

        return ResponseEntity.ok().body(result);
    }
}
