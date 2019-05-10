package com.virros.department.controllers;

import com.virros.department.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestRestController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getTestMessage() {

        return ResponseEntity.ok().body(departmentService.getDepartment(1));
    }
}
